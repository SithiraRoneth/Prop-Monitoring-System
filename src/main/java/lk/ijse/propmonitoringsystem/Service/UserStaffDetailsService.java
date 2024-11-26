package lk.ijse.propmonitoringsystem.Service;

import lk.ijse.propmonitoringsystem.dto.impl.UserStaffDetailsDto;

import java.util.List;

public interface UserStaffDetailsService {
    void saveUserStaffDetails(UserStaffDetailsDto userStaffDetailsDto);
    List<UserStaffDetailsDto> getAllUserStaffDetails();
}
