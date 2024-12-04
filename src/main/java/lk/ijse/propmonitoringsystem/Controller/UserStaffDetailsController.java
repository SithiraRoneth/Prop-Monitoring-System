package lk.ijse.propmonitoringsystem.Controller;

import lk.ijse.propmonitoringsystem.Service.UserStaffDetailsService;
import lk.ijse.propmonitoringsystem.dto.impl.DutyManageDto;
import lk.ijse.propmonitoringsystem.dto.impl.UserStaffDetailsDto;
import lk.ijse.propmonitoringsystem.exception.DataPersistException;
import lk.ijse.propmonitoringsystem.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("UserStaff/")
public class UserStaffDetailsController {
    @Autowired
    private UserStaffDetailsService userStaffDetailsService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Void> saveUserStaffDetails(
            @RequestPart("userStaffId")String userStaffId,
            @RequestPart("userId") String userId,
            @RequestPart("staffId") String staffId,
            @RequestPart("Role") String role
    )

    {
        try {
            //StaffFieldId generate
//            String userStaffCode = AppUtil.generateUserStaffId();

            //Build the Object
            UserStaffDetailsDto buildUserStaffDetailsDto = new UserStaffDetailsDto();
            buildUserStaffDetailsDto.setUserStaffId(userStaffId);
            buildUserStaffDetailsDto.setUserId(userId);
            buildUserStaffDetailsDto.setStaffId(staffId);
            userStaffDetailsService.saveUserStaffDetails(buildUserStaffDetailsDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserStaffDetailsDto> getAllUserStaffDetails() {
        return userStaffDetailsService.getAllUserStaffDetails();
    }
}
