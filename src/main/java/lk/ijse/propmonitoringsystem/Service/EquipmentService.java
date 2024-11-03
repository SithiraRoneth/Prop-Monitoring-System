package lk.ijse.propmonitoringsystem.Service;


import lk.ijse.propmonitoringsystem.dto.EquipmentStatus;
import lk.ijse.propmonitoringsystem.dto.impl.EquipmentDto;

import java.util.List;

public interface EquipmentService {
    void saveEquipment(EquipmentDto equipmentDto);
    EquipmentStatus getSelectedEquipment(String equipmentId);
    List<EquipmentDto> getAllEquipment();
    void updateEquipment(String equipmentId,EquipmentDto equipmentDto);
    void deleteEquipment(String equipmentId);
}
