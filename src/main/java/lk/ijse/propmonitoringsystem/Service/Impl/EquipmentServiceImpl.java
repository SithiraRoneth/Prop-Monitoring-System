/* Created By Sithira Roneth
 * Date :10/29/24
 * Time :10:34
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoringsystem.Service.Impl;

import lk.ijse.propmonitoringsystem.Service.EquipmentService;
import lk.ijse.propmonitoringsystem.customStatusCode.SelectedErrorStatus;
import lk.ijse.propmonitoringsystem.dao.EquipmentDao;
import lk.ijse.propmonitoringsystem.dto.EquipmentStatus;
import lk.ijse.propmonitoringsystem.dto.impl.EquipmentDto;
import lk.ijse.propmonitoringsystem.entity.impl.Equipment;
import lk.ijse.propmonitoringsystem.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentServiceImpl implements EquipmentService {
    @Autowired
    private EquipmentDao equipmentDao;
    @Autowired
    private Mapping mapping;

    @Override
    public void saveEquipment(EquipmentDto equipmentDto) {
        Equipment savedEquip = equipmentDao.save(mapping.toEquipmentEntity(equipmentDto));
        if (savedEquip == null) {
            throw new RuntimeException("Save equipment failed");
        }
    }

    @Override
    public EquipmentStatus getSelectedEquipment(String equipmentId) {
        if (equipmentDao.existsById(equipmentId)) {
            Equipment selectedEquip = equipmentDao.getReferenceById(equipmentId);
            return mapping.toEquipmentDto(selectedEquip);
        }else {
            return new SelectedErrorStatus(2,"Equipment not found");
        }
    }

    @Override
    public List<EquipmentDto> getAllEquipment() {
        List<Equipment> allEquipments = equipmentDao.findAll();
        return mapping.toEquipmentDtoList(allEquipments);
    }

    @Override
    public void updateEquipment(String equipmentId, EquipmentDto equipmentDto) {
        Optional<Equipment> tempEquip = equipmentDao.findById(equipmentId);
        if (tempEquip.isPresent()) {
            Equipment equipment = tempEquip.get();
            equipment.setEquipmentName(equipmentDto.getEquipmentName());
            equipment.setEquipmentType(equipmentDto.getEquipmentType());
            equipment.setStatus(equipmentDto.getStatus());

            // ToDo: want to add more
        }
    }

    @Override
    public void deleteEquipment(String equipmentId) {
        Optional<Equipment> existEquip = equipmentDao.findById(equipmentId);
        if (existEquip.isPresent()) {
            throw new RuntimeException("Delete equipment failed");
        }else {
            equipmentDao.deleteById(equipmentId);
        }
    }
}
