/* Created By Sithira Roneth
 * Date :11/21/24
 * Time :12:31
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoringsystem.Controller;

import lk.ijse.propmonitoringsystem.Service.StaffFieldDetailsService;
import lk.ijse.propmonitoringsystem.dto.impl.StaffFieldDetailsDto;
import lk.ijse.propmonitoringsystem.exception.DataPersistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/dutyManage")
public class DutyManageController {
    @Autowired
    private StaffFieldDetailsService staffFieldDetailsService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveStaffFieldDetails(
            @RequestPart("staffEquipmentId") String staffFieldId,
            @RequestPart ("StaffId") String staffId,
            @RequestPart ("FieldId") String fieldId
    ) {
        try {
            StaffFieldDetailsDto buildStaffField = new StaffFieldDetailsDto();
            buildStaffField.setStaffFieldId(staffFieldId);
            buildStaffField.setStaffId(staffId);
            buildStaffField.setFieldCode(fieldId);
            staffFieldDetailsService.saveStaffFieldDetails(buildStaffField);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<StaffFieldDetailsDto> getStaffFieldDetails() {
//        return staffFieldDetailsService.getAllStaffFieldDetails();
//    }
}
