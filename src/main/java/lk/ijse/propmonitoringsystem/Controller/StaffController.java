/* Created By Sithira Roneth
 * Date :10/29/24
 * Time :10:26
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoringsystem.Controller;

import lk.ijse.propmonitoringsystem.Service.StaffService;
import lk.ijse.propmonitoringsystem.dao.StaffDao;
import lk.ijse.propmonitoringsystem.dto.impl.StaffDto;
import lk.ijse.propmonitoringsystem.entity.Gender;
import lk.ijse.propmonitoringsystem.entity.Role;
import lk.ijse.propmonitoringsystem.entity.impl.Staff;
import lk.ijse.propmonitoringsystem.exception.DataPersistException;
import lk.ijse.propmonitoringsystem.exception.StaffNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/staffs")
public class StaffController {
    @Autowired
    private StaffService staffService;
    @Autowired
    private StaffDao staffDao;

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

//    @GetMapping(value = "{email}/role", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<?> getStaffRole(@PathVariable("email") String email) {
//        try {
//            if (staffDao.existsById(email)) {
//
//                Staff staff = staffDao.getReferenceById(email);
//                String role = staff.getRole().name();
//                return ResponseEntity.ok(role); // Return the role
//            } else {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                        .body("Staff with email " + email + " not found");
//            }
//        } catch (Exception e) {
//            // Log the error and return a generic error message
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Unable to check role for the staff.");
//        }
//    }

//    @GetMapping(value = "{email}/role", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<?> getStaffRole(@PathVariable("email") String email) {
//        try {
//            if (staffDao.existsById(email)) {
//                // Fetch the staff details by email
//                Staff staff = staffDao.getReferenceById(email);  // Get the staff entity using email
//
//                // Get the role of the staff member
//                String role = staff.getRole().name();  // Assuming 'role' is an enum in the Staff entity
//
//                // Return the role as a response
//                return ResponseEntity.ok(role); // Send the role as a response (can be modified as per frontend expectation)
//            } else {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                        .body("Staff with email " + email + " not found");
//            }
//        } catch (Exception e) {
//            // Log the error and return a generic error message
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Unable to check role for the staff.");
//        }
//    }

    @GetMapping(value = "{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getSelectedVehicle(@PathVariable("email") String email) {
        return staffService.getSelectedStaff(email);
    }

    @GetMapping(value = "{email}/role", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Role> getStaffRole(@PathVariable("email") String email) {
        try {
            if (staffDao.existsById(email)) {
                Staff staff = staffDao.getReferenceById(email);  // Get the staff record
                Role role = Role.valueOf(staff.getRole().name());  // Get the role of the staff as a string
                return ResponseEntity.ok(role);  // Return the role as the response body
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(Role.valueOf("Staff with email " + email + " not found"));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Role.valueOf("Error fetching staff role."));
        }
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
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (StaffNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
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
