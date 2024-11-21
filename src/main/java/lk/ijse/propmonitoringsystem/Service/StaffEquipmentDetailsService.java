package lk.ijse.propmonitoringsystem.Service;

import lk.ijse.propmonitoringsystem.dto.impl.StaffEquipmentDto;

import java.util.List;

public interface StaffEquipmentDetailsService {
    void saveStaffEquipmentDetails(StaffEquipmentDto staffEquipmentDto);
    List<StaffEquipmentDto> getAllStaffEquipmentDetails();
}
