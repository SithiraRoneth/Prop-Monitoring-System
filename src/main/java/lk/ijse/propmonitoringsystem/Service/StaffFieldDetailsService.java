package lk.ijse.propmonitoringsystem.Service;

import lk.ijse.propmonitoringsystem.dto.impl.StaffFieldDetailsDto;

import java.util.List;

public interface StaffFieldDetailsService {
    void saveStaffFieldDetails(StaffFieldDetailsDto staffFieldDetailsDto);
    List<StaffFieldDetailsDto> getAllStaffFieldDetails();
}
