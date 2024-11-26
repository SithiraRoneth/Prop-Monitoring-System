package lk.ijse.propmonitoringsystem.Service.Impl;

import jakarta.transaction.Transactional;
import lk.ijse.propmonitoringsystem.Service.UserStaffDetailsService;
import lk.ijse.propmonitoringsystem.dao.UserStaffDetailsDao;
import lk.ijse.propmonitoringsystem.dto.impl.UserStaffDetailsDto;
import lk.ijse.propmonitoringsystem.entity.impl.UserStaffDetails;
import lk.ijse.propmonitoringsystem.exception.DataPersistException;
import lk.ijse.propmonitoringsystem.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserStaffDetailsServiceImpl implements UserStaffDetailsService {
    @Autowired
    private Mapping mapping;

    @Autowired
    private UserStaffDetailsDao userStaffDetailsDao;

    @Override
    public void saveUserStaffDetails(UserStaffDetailsDto userStaffDetailsDto) {
        UserStaffDetails savedUserStaffDetails = userStaffDetailsDao.save((mapping.toUserStaffDetailsEntity(userStaffDetailsDto)));
        if (savedUserStaffDetails == null) {
            throw new DataPersistException("Staff Not Saved...!!! ");
        }
    }

    @Override
    public List<UserStaffDetailsDto> getAllUserStaffDetails() {
        List<UserStaffDetails> allUserStaffDetails = userStaffDetailsDao.findAll();
        return mapping.UserStaffDetailsList(allUserStaffDetails);
    }
}
