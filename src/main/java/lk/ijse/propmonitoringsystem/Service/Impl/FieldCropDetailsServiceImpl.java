/* Created By Sithira Roneth
 * Date :11/21/24
 * Time :11:52
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoringsystem.Service.Impl;

import jakarta.transaction.Transactional;
import lk.ijse.propmonitoringsystem.Service.FieldCropDetailsService;
import lk.ijse.propmonitoringsystem.dao.EquipmentManageDao;
import lk.ijse.propmonitoringsystem.dto.impl.FieldCropDetailsDto;
import lk.ijse.propmonitoringsystem.entity.impl.EquipmentManage;
import lk.ijse.propmonitoringsystem.exception.DataPersistException;
import lk.ijse.propmonitoringsystem.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class FieldCropDetailsServiceImpl implements FieldCropDetailsService {
    @Autowired
    private Mapping mapping;
    @Autowired
    private EquipmentManageDao fieldEquipmentDetailsDao;
    @Override
    public void saveFieldEquipmentDetails(FieldCropDetailsDto fieldEquipmentDetailsDto) {
        EquipmentManage saveFieldEquipmentDetails = fieldEquipmentDetailsDao.save(mapping.toFieldEquipmentDetailsEntity(fieldEquipmentDetailsDto));
        if (saveFieldEquipmentDetails == null) {
            throw new DataPersistException("Field equipment details not saved");
        }
    }

    @Override
    public List<FieldCropDetailsDto> getAllFieldEquipmentDetails() {
        List<EquipmentManage> all = fieldEquipmentDetailsDao.findAll();
        return mapping.toFieldEquipmentDetailsDtoList(all);
    }
}
