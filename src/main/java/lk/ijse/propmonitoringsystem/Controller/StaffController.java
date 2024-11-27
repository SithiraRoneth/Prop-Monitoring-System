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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/staffs")
public class StaffController {
    @Autowired
    private StaffService staffService;

//    private Logger logger = LoggerFactory.getLogger(StaffController.class);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveStaff(@RequestBody StaffDto staffDto) {
//            @RequestPart("staff_id") String staffId,
//            @RequestPart("first_name") String firstName,
//            @RequestPart("last_name") String lastName,
//            @RequestPart("designation") String designation,
//            @RequestPart("gender") String gender,
//            @RequestPart("joined_date") Date joinedDate,
//            @RequestPart("dob") Date dob,
//            @RequestPart("address") String address,
//            @RequestPart("contact_no") String contactNo,
//            @RequestPart("email") String email,
//            @RequestPart("role") String role
//            ) {
        try {
            var buildStaff = new StaffDto();
            buildStaff.setStaffId(staffDto.getStaffId());
            buildStaff.setFirstName(staffDto.getFirstName());
            buildStaff.setLastName(staffDto.getLastName());
            buildStaff.setDesignation(staffDto.getDesignation());
            buildStaff.setGender(Gender.valueOf(String.valueOf(staffDto.getGender())));
            buildStaff.setJoinedDate(staffDto.getJoinedDate());
            buildStaff.setDob(staffDto.getDob());
            buildStaff.setAddress(staffDto.getAddress());
            buildStaff.setContactNo(staffDto.getContactNo());
            buildStaff.setEmail(staffDto.getEmail());
            buildStaff.setRole(Role.valueOf(String.valueOf(staffDto.getRole())));
//            System.out.println(buildStaff);
//            System.out.println(role);
//            buildStaff.setStaffId(staffId);
//            buildStaff.setFirstName(firstName);
//            buildStaff.setLastName(lastName);
//            buildStaff.setDesignation(designation);
//            buildStaff.setGender(Gender.valueOf(gender));
//            buildStaff.setJoinedDate(joinedDate);
//            buildStaff.setDob(dob);
//            buildStaff.setAddress(address);
//            buildStaff.setContactNo(contactNo);
//            buildStaff.setEmail(email);
//            buildStaff.setRole(Role.valueOf(role));
            staffService.saveStaff(buildStaff);
            System.out.println(buildStaff);
//            logger.info("staff saved");
            return new ResponseEntity<>(HttpStatus.CREATED);

        } catch (DataPersistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "{staffId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public StaffStatus getSelectedStaff(@PathVariable("staffId") String staffId) {
        return staffService.getSelectedStaff(staffId);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StaffDto> getStaffs() {
        return staffService.getAllStaff();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "{staffId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteStaff(@PathVariable("staffId") String staffId) {
        try {
            staffService.deleteStaff(staffId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (StaffNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "{staffId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateStaff(@PathVariable("staffId") String staffId, StaffDto staffDto) {
        try {
            var buildStaff = new StaffDto();
            buildStaff.setStaffId(staffDto.getStaffId());
            buildStaff.setFirstName(staffDto.getFirstName());
            buildStaff.setLastName(staffDto.getLastName());
            buildStaff.setDesignation(staffDto.getDesignation());
            buildStaff.setGender(Gender.valueOf(String.valueOf(staffDto.getGender())));
            buildStaff.setJoinedDate(staffDto.getJoinedDate());
            buildStaff.setDob(staffDto.getDob());
            buildStaff.setAddress(staffDto.getAddress());
            buildStaff.setContactNo(staffDto.getContactNo());
            buildStaff.setEmail(staffDto.getEmail());
            buildStaff.setRole(Role.valueOf(String.valueOf(staffDto.getRole())));

            staffService.updateStaff(staffId, buildStaff);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
