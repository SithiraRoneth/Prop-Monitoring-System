package lk.ijse.propmonitoringsystem.Service;

import lk.ijse.propmonitoringsystem.dto.impl.EquipmentManageDto;
import lk.ijse.propmonitoringsystem.dto.impl.StaffFieldDetailsDto;

import java.util.List;

public interface EquipmentManageService {
    void saveEquipmentManage(EquipmentManageDto equipmentManageDto);
    List<EquipmentManageDto> getAllEquipmentManage();
}
