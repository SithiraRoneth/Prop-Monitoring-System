/* Created By Sithira Roneth
 * Date :11/21/24
 * Time :12:01
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoringsystem.Service.Impl;

import jakarta.transaction.Transactional;
import lk.ijse.propmonitoringsystem.Service.StaffEquipmentDetailsService;
import lk.ijse.propmonitoringsystem.dao.StaffEquipmentDao;
import lk.ijse.propmonitoringsystem.dto.StaffEquipmentStatus;
import lk.ijse.propmonitoringsystem.dto.impl.StaffEquipmentDto;
import lk.ijse.propmonitoringsystem.entity.impl.StaffEquipmentDetails;
import lk.ijse.propmonitoringsystem.exception.DataPersistException;
import lk.ijse.propmonitoringsystem.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class StaffEquipmentDetailsServiceImpl implements StaffEquipmentDetailsService {
    @Autowired
    private Mapping mapping;

    @Autowired
    private StaffEquipmentDao staffEquipmentDao;
    @Override
    public void saveStaffEquipmentDetails(StaffEquipmentDto staffEquipmentDto) {
        StaffEquipmentDetails saved = staffEquipmentDao.save(mapping.toStaffEquipmentDetailsEntity(staffEquipmentDto));
        if (saved == null) {
            throw new DataPersistException("save staff equipment failed");
        }
    }

    @Override
    public List<StaffEquipmentDto> getAllStaffEquipmentDetails() {
        List<StaffEquipmentDetails> all = staffEquipmentDao.findAll();
        return mapping.StaffEquipmentDetailsList(all);
    }
}
