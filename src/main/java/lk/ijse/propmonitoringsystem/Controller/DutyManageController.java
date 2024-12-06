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
import lk.ijse.propmonitoringsystem.entity.impl.Field;
import lk.ijse.propmonitoringsystem.entity.impl.Staff;
import lk.ijse.propmonitoringsystem.exception.DataPersistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/dutyManage")
public class DutyManageController {
    @Autowired
    private DutyManageService dutyManageService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> saveDutyManage(
            @RequestPart("duty_id") String dutyId,
            @RequestPart("date") String date,
            @RequestPart("duty") String duty,
            @RequestPart("time_period") String timePeriod,
            @RequestPart("field_code") String field,
            @RequestPart("staff_email") String mail
    ) {
        try {
            // Build the DTO
            DutyManageDto buildDutyManage = new DutyManageDto();
            buildDutyManage.setDuty_id(dutyId);
            buildDutyManage.setDate(date);
            buildDutyManage.setDuty(duty);
            buildDutyManage.setTimePeriod(timePeriod);
            buildDutyManage.setField_code(field);
            buildDutyManage.setStaff_email(mail);

            // Log the DTO for debugging
            System.out.println("Built DTO: " + buildDutyManage);

            // Call the service to save the data
            dutyManageService.saveDutyManage(buildDutyManage);

            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DutyManageDto> getAllDutyManage() {
        List<DutyManageDto> allDutyManage = dutyManageService.getAllDutyManage();
        System.out.println(allDutyManage);
        return allDutyManage;
    }
}
