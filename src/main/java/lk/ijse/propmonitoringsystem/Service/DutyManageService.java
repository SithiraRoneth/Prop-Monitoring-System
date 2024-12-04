package lk.ijse.propmonitoringsystem.Service;

import lk.ijse.propmonitoringsystem.dto.impl.DutyManageDto;
import lk.ijse.propmonitoringsystem.dto.impl.EquipmentManageDto;

import java.util.List;

public interface DutyManageService {
    void saveDutyManage(DutyManageDto dutyManageDto);
    List<DutyManageDto> getAllDutyManage();
}
