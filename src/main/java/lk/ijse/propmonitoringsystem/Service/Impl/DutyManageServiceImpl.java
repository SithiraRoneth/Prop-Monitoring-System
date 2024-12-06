/* Created By Sithira Roneth
 * Date :12/4/24
 * Time :09:17
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoringsystem.Service.Impl;

import jakarta.transaction.Transactional;
import lk.ijse.propmonitoringsystem.Service.DutyManageService;
import lk.ijse.propmonitoringsystem.dao.DutyManageDao;
import lk.ijse.propmonitoringsystem.dto.impl.DutyManageDto;
import lk.ijse.propmonitoringsystem.entity.impl.DutyManage;
import lk.ijse.propmonitoringsystem.entity.impl.Field;
import lk.ijse.propmonitoringsystem.entity.impl.Staff;
import lk.ijse.propmonitoringsystem.exception.DataPersistException;
import lk.ijse.propmonitoringsystem.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class DutyManageServiceImpl implements DutyManageService {
    @Autowired
    private Mapping mapping;

    @Autowired
    private DutyManageDao dutyManageDao;

    @Override
    public void saveDutyManage(DutyManageDto dutyManageDto) {
        DutyManage entity = mapping.toDutyManageEntity(dutyManageDto);

        if (dutyManageDto.getStaff_email() != null) {
            Staff staff = new Staff(dutyManageDto.getStaff_email());
            entity.setStaff(staff);
        }

        if (dutyManageDto.getField_code() != null) {
            Field field = new Field(dutyManageDto.getField_code());
            entity.setField(field);
        }

        DutyManage savedEntity = dutyManageDao.save(entity);

        if (savedEntity == null) {
            throw new DataPersistException("Save duty manage details failed");
        }
    }


    @Override
    public List<DutyManageDto> getAllDutyManage() {
        List<DutyManage> allDutyManage = dutyManageDao.findAll();
        return mapping.toDutyManageDtoList(allDutyManage);
    }
}
