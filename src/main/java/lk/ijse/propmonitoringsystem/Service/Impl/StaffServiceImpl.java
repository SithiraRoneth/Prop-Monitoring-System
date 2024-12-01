/* Created By Sithira Roneth
 * Date :10/29/24
 * Time :10:33
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoringsystem.Service.Impl;

import jakarta.persistence.EntityNotFoundException;
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
        System.out.println("ane :"+mapping.toStaffEntity(staffDto));
        Staff savedStaff = staffDao.save(mapping.toStaffEntity(staffDto));
        if (savedStaff == null) {
            throw new RuntimeException("Failed to save staff");
        }
    }

    @Override
    public void updateStaff(String email, StaffDto staffDto) {
        if (staffDto == null) {
            throw new IllegalArgumentException("StaffDto cannot be null");
        }

        Optional<Staff> tempStaff = staffDao.findById(email);
        if (tempStaff.isPresent()) {
            Staff staff = tempStaff.get();
            staff.setFirstName(staffDto.getFirstName());
            staff.setLastName(staffDto.getLastName());
            staff.setDesignation(staffDto.getDesignation());

            try {
                staff.setGender(Gender.valueOf(staffDto.getGender()));  // Ensure correct enum mapping
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid gender value: " + staffDto.getGender(), e);
            }

            staff.setJoinedDate(staffDto.getJoinedDate());
            staff.setAddress(staffDto.getAddress());
            staff.setContactNo(staffDto.getContactNo());

            // Save the updated staff object
            staffDao.save(staff);  // Persist the changes in the database
        } else {
            throw new EntityNotFoundException("Staff with email " + email + " not found.");
        }
    }



    @Override
    public void deleteStaff(String email) {
        Optional<Staff> existStaff = staffDao.findById(email);
        if (!existStaff.isPresent()) {
            throw new StaffNotFoundException("Staff not found with ID: " + email); // Correctly throw when staff doesn't exist
        } else {
            staffDao.deleteById(email); // Delete the staff record if found
        }
    }

    @Override
    public StaffStatus getSelectedStaff(String email) {
        if (staffDao.existsById(email)) {
            Staff staff = staffDao.getReferenceById(email);
            return mapping.toStaffDto(staff);
        } else {
            return new SelectedErrorStatus(2, "Staff with code " + email + " not found");
        }
    }

    @Override
    public List<StaffDto> getAllStaff() {
        List<Staff> allStaff = staffDao.findAll();
        return mapping.toStaffDtoList(allStaff);
    }
}
