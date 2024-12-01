/* Created By Sithira Roneth
 * Date :10/29/24
 * Time :10:26
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoringsystem.Controller;

import lk.ijse.propmonitoringsystem.Service.StaffService;
import lk.ijse.propmonitoringsystem.dto.StaffStatus;
import lk.ijse.propmonitoringsystem.dto.impl.StaffDto;
import lk.ijse.propmonitoringsystem.entity.Gender;
import lk.ijse.propmonitoringsystem.entity.Role;
import lk.ijse.propmonitoringsystem.exception.DataPersistException;
import lk.ijse.propmonitoringsystem.exception.StaffNotFoundException;
import lk.ijse.propmonitoringsystem.util.AppUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/staffs")
public class StaffController {
    @Autowired
    private StaffService staffService;

//    private Logger logger = LoggerFactory.getLogger(StaffController.class);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveStaff(@RequestBody StaffDto staffDto) {

        try {
            var buildStaff = new StaffDto();
            buildStaff.setEmail(staffDto.getEmail());
            buildStaff.setFirstName(staffDto.getFirstName());
            buildStaff.setLastName(staffDto.getLastName());
            buildStaff.setDesignation(staffDto.getDesignation());
            buildStaff.setGender(String.valueOf(Gender.valueOf(String.valueOf(staffDto.getGender()))));
            buildStaff.setJoinedDate(staffDto.getJoinedDate());
            //buildStaff.setDob(staffDto.getDob());
            buildStaff.setAddress(staffDto.getAddress());
            buildStaff.setContactNo(staffDto.getContactNo());
            buildStaff.setRole(staffDto.getRole());
            System.out.println(buildStaff);
            staffService.saveStaff(buildStaff);
//            logger.info("staff saved");
            return new ResponseEntity<>(HttpStatus.CREATED);

        } catch (DataPersistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public StaffStatus getSelectedStaff(@PathVariable("email") String email) {
        return staffService.getSelectedStaff(email);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StaffDto> getStaffs() {
        return staffService.getAllStaff();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteStaff(@PathVariable("email") String email) {
        try {
            staffService.deleteStaff(email);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Successful deletion
        } catch (StaffNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Staff not found
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // General error
        }
    }


    @PutMapping(value = "/{email}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateStaff(@PathVariable("email") String email, @RequestBody StaffDto staffDto) {
        try {
            staffService.updateStaff(email, staffDto);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
