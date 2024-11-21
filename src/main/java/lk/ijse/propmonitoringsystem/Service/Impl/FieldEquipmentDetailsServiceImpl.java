/* Created By Sithira Roneth
 * Date :11/21/24
 * Time :11:52
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoringsystem.Service.Impl;

import jakarta.transaction.Transactional;
import lk.ijse.propmonitoringsystem.Service.FieldEquipmentDetailsService;
import lk.ijse.propmonitoringsystem.dao.FieldEquipmentDetailsDao;
import lk.ijse.propmonitoringsystem.dto.impl.FieldEquipmentDetailsDto;
import lk.ijse.propmonitoringsystem.entity.impl.FieldEquipmentDetails;
import lk.ijse.propmonitoringsystem.exception.DataPersistException;
import lk.ijse.propmonitoringsystem.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class FieldEquipmentDetailsServiceImpl implements FieldEquipmentDetailsService {
    @Autowired
    private Mapping mapping;
    @Autowired
    private FieldEquipmentDetailsDao fieldEquipmentDetailsDao;
    @Override
    public void saveFieldEquipmentDetails(FieldEquipmentDetailsDto fieldEquipmentDetailsDto) {
        FieldEquipmentDetails saveFieldEquipmentDetails = fieldEquipmentDetailsDao.save(mapping.toFieldEquipmentDetailsEntity(fieldEquipmentDetailsDto));
        if (saveFieldEquipmentDetails == null) {
            throw new DataPersistException("Field equipment details not saved");
        }
    }

    @Override
    public List<FieldEquipmentDetailsDto> getAllFieldEquipmentDetails() {
        List<FieldEquipmentDetails> all = fieldEquipmentDetailsDao.findAll();
        return mapping.FieldEquipmentDetailsList(all);
    }
}
