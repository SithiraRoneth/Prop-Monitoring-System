package lk.ijse.propmonitoringsystem.Service;

import lk.ijse.propmonitoringsystem.dto.impl.FieldCropDetailsDto;

import java.util.List;

public interface FieldCropDetailsService {
    void saveFieldEquipmentDetails(FieldCropDetailsDto fieldEquipmentDetailsDto);
    List<FieldCropDetailsDto> getAllFieldEquipmentDetails();
}
