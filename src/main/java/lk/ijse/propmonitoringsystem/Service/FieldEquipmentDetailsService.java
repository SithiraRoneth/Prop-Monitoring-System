package lk.ijse.propmonitoringsystem.Service;

import lk.ijse.propmonitoringsystem.dto.impl.FieldEquipmentDetailsDto;
import lk.ijse.propmonitoringsystem.entity.impl.FieldEquipmentDetails;

import java.util.List;

public interface FieldEquipmentDetailsService {
    void saveFieldEquipmentDetails(FieldEquipmentDetailsDto fieldEquipmentDetailsDto);
    List<FieldEquipmentDetailsDto> getAllFieldEquipmentDetails();
}
