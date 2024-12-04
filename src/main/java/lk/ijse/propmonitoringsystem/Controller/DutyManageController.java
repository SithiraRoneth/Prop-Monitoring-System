/* Created By Sithira Roneth
 * Date :11/21/24
 * Time :12:31
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoringsystem.Controller;

import lk.ijse.propmonitoringsystem.Service.DutyManageService;
import lk.ijse.propmonitoringsystem.Service.EquipmentManageService;
import lk.ijse.propmonitoringsystem.dto.impl.DutyManageDto;
import lk.ijse.propmonitoringsystem.dto.impl.StaffFieldDetailsDto;
import lk.ijse.propmonitoringsystem.exception.DataPersistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/dutyManage")
public class DutyManageController {
    @Autowired
    private DutyManageService dutyManageService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveDutyManage(
            @RequestPart("dutyManageId") String dutyId,
            @RequestPart ("StaffId") String staffId,
            @RequestPart ("FieldId") String fieldId,
            @RequestPart ("date") String date,
            @RequestPart ("timePeriod") String timePeriod
            ) {
        try {
            DutyManageDto buildDutyManage = new DutyManageDto();
            buildDutyManage.setDutyId(dutyId);
            buildDutyManage.setStaffId(staffId);
            buildDutyManage.setFieldId(fieldId);
            buildDutyManage.setDate(date);
            buildDutyManage.setTimePeriod(timePeriod);
            dutyManageService.saveDutyManage(buildDutyManage);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DutyManageDto> getAllDutyManage() {
        return dutyManageService.getAllDutyManage();
    }
}
