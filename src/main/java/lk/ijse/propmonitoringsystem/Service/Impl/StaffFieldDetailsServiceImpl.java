/* Created By Sithira Roneth
 * Date :11/21/24
 * Time :12:09
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoringsystem.Service.Impl;

import jakarta.transaction.Transactional;
import lk.ijse.propmonitoringsystem.Service.StaffFieldDetailsService;
import lk.ijse.propmonitoringsystem.dao.StaffFieldDetailsDao;
import lk.ijse.propmonitoringsystem.dto.impl.StaffFieldDetailsDto;
import lk.ijse.propmonitoringsystem.entity.impl.StaffFieldDetails;
import lk.ijse.propmonitoringsystem.exception.DataPersistException;
import lk.ijse.propmonitoringsystem.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class StaffFieldDetailsServiceImpl implements StaffFieldDetailsService {
    @Autowired
    private Mapping mapping;
    @Autowired
    private StaffFieldDetailsDao staffFieldDetailsdao;
    @Override
    public void saveStaffFieldDetails(StaffFieldDetailsDto staffFieldDetailsDto) {
        StaffFieldDetails save = staffFieldDetailsdao.save(mapping.toStaffFieldDetailsEntity(staffFieldDetailsDto));
        if (save == null) {
            throw new DataPersistException("save staff field details failed");
        }
    }

    @Override
    public List<StaffFieldDetailsDto> getAllStaffFieldDetails() {
        List<StaffFieldDetails> all = staffFieldDetailsdao.findAll();
        return mapping.StaffFieldDetailsList(all);
    }
}
