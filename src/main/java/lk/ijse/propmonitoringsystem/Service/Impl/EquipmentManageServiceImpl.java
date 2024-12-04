/* Created By Sithira Roneth
 * Date :11/21/24
 * Time :12:09
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoringsystem.Service.Impl;

import jakarta.transaction.Transactional;
import lk.ijse.propmonitoringsystem.Service.EquipmentManageService;
import lk.ijse.propmonitoringsystem.dao.EquipmentManageDao;
import lk.ijse.propmonitoringsystem.dao.StaffFieldDetailsDao;
import lk.ijse.propmonitoringsystem.dto.impl.EquipmentManageDto;
import lk.ijse.propmonitoringsystem.dto.impl.StaffFieldDetailsDto;
import lk.ijse.propmonitoringsystem.entity.impl.DutyManage;
import lk.ijse.propmonitoringsystem.entity.impl.EquipmentManage;
import lk.ijse.propmonitoringsystem.exception.DataPersistException;
import lk.ijse.propmonitoringsystem.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class EquipmentManageServiceImpl implements EquipmentManageService {
    @Autowired
    private Mapping mapping;

    @Autowired
    private EquipmentManageDao equipmentManageDao;

    @Override
    public void saveEquipmentManage(EquipmentManageDto equipmentManageDto) {
        EquipmentManage save = equipmentManageDao.save(mapping.toEquipmentManageEntity(equipmentManageDto));
        if (save == null) {
            throw new DataPersistException("save equipment manage details failed");
        }
    }

    @Override
    public List<EquipmentManageDto> getAllEquipmentManage() {
        List<EquipmentManage> all = equipmentManageDao.findAll();
        return mapping.toEquipmentManageDtoList(all);
    }
}
