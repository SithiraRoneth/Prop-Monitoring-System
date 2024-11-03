package lk.ijse.propmonitoringsystem.Service;

import lk.ijse.propmonitoringsystem.dto.StaffStatus;
import lk.ijse.propmonitoringsystem.dto.impl.StaffDto;

import java.util.List;

public interface StaffService {
    void saveStaff(StaffDto staffDto);
    void updateStaff(String staffId,StaffDto staffDto);
    void deleteStaff(String staffId);
    StaffStatus getSelectedStaff(String staffId);
    List<StaffDto> getAllStaff();
}
