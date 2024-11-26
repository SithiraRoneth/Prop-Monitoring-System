package lk.ijse.propmonitoringsystem.Service;

import lk.ijse.propmonitoringsystem.dto.impl.FieldEquipmentDetailsDto;

import java.util.List;

public interface FieldEquipmentDetailsService {
    void saveFieldEquipmentDetails(FieldEquipmentDetailsDto fieldEquipmentDetailsDto);
    List<FieldEquipmentDetailsDto> getAllFieldEquipmentDetails();
}
