/* Created By Sithira Roneth
 * Date :10/29/24
 * Time :10:33
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoringsystem.Service.Impl;

import lk.ijse.propmonitoringsystem.Service.StaffService;
import lk.ijse.propmonitoringsystem.customStatusCode.SelectedErrorStatus;
import lk.ijse.propmonitoringsystem.dao.StaffDao;
import lk.ijse.propmonitoringsystem.dto.StaffStatus;
import lk.ijse.propmonitoringsystem.dto.impl.StaffDto;
import lk.ijse.propmonitoringsystem.entity.Gender;
import lk.ijse.propmonitoringsystem.entity.Role;
import lk.ijse.propmonitoringsystem.entity.impl.Staff;
import lk.ijse.propmonitoringsystem.exception.StaffNotFoundException;
import lk.ijse.propmonitoringsystem.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffDao staffDao;
    @Autowired
    private Mapping mapping;

    @Override
    public void saveStaff(StaffDto staffDto) {
        Staff savedStaff = staffDao.save(mapping.toStaffEntity(staffDto));
        if (savedStaff == null) {
            throw new RuntimeException("Failed to save staff");
        }
    }

    @Override
    public void updateStaff(String staffId, StaffDto staffDto) {
        Optional<Staff> tempStaff = staffDao.findById(staffId);
        if (tempStaff.isPresent()) {
            Staff staff = tempStaff.get();
            staff.setFirstName(staffDto.getFirstName());
            staff.setLastName(staffDto.getLastName());
            staff.setDesignation(staffDto.getDesignation());
            staff.setGender(Gender.valueOf(String.valueOf(staffDto.getGender())));
            staff.setJoinedDate(staffDto.getJoinedDate());
            staff.setDob(staffDto.getDob());
            staff.setAddress(staffDto.getAddress());
//            staff.setAddressLine2(staffDto.getAddressLine2());
//            staff.setAddressLine3(staffDto.getAddressLine3());
//            staff.setAddressLine4(staffDto.getAddressLine4());
//            staff.setAddressLine5(staffDto.getAddressLine5());
            staff.setContactNo(staffDto.getContactNo());
            staff.setEmail(staffDto.getEmail());
            staff.setRole(Role.valueOf(String.valueOf(staffDto.getRole())));
        }
    }

    @Override
    public void deleteStaff(String staffId) {
        Optional<Staff> existStaff = staffDao.findById(staffId);
        if (!existStaff.isPresent()) {
            throw new StaffNotFoundException("Staff not found with ID: " + staffId); // Correctly throw when staff doesn't exist
        } else {
            staffDao.deleteById(staffId); // Delete the staff record if found
        }
    }

    @Override
    public StaffStatus getSelectedStaff(String staffId) {
        if (staffDao.existsById(staffId)) {
            Staff staff = staffDao.getReferenceById(staffId);
            return mapping.toStaffDto(staff);
        } else {
            return new SelectedErrorStatus(2, "Staff with code " + staffId + " not found");
        }
    }

    @Override
    public List<StaffDto> getAllStaff() {
        List<Staff> allStaff = staffDao.findAll();
        return mapping.toStaffDtoList(allStaff);
    }
}
