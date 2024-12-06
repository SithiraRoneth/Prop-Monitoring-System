/* Created By Sithira Roneth
 * Date :10/29/24
 * Time :10:34
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoringsystem.Service.Impl;

import lk.ijse.propmonitoringsystem.Service.UserService;
import lk.ijse.propmonitoringsystem.customStatusCode.SelectedErrorStatus;
import lk.ijse.propmonitoringsystem.dao.UserDao;
import lk.ijse.propmonitoringsystem.dto.EquipmentStatus;
import lk.ijse.propmonitoringsystem.dto.UserStatus;
import lk.ijse.propmonitoringsystem.dto.impl.UserDto;
import lk.ijse.propmonitoringsystem.entity.Role;
import lk.ijse.propmonitoringsystem.entity.impl.Equipment;
import lk.ijse.propmonitoringsystem.entity.impl.User;
import lk.ijse.propmonitoringsystem.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private Mapping mapping;

    @Override
    public void userSave(UserDto userDto) {
        User save = userDao.save(mapping.toUserEntity(userDto));
        if (save == null){
            throw new RuntimeException("Save user failed");
        }
    }
    @Override
    public String getRoleByEmail(String email) {
        User user = userDao.findById(email).orElseThrow(() ->
                new RuntimeException("Staff not found with email: " + email));
        return user.getRole().name();
    }

    @Override
    public UserStatus getSelectedUser(String email) {
        if (userDao.existsById(email)) {
            User selectedEmail = userDao.getReferenceById(email);
            return mapping.toUserDto(selectedEmail);
        }else {
            return new SelectedErrorStatus(2,"User not found");
        }
    }

    @Override
    public boolean validateUser(String email, String password) {
        User user = userDao.findByEmail(email);
        return user != null && user.getPassword().equals(password);
    }

    @Override
    public void updateUser(String email, String newPassword) {
        User user = userDao.findByEmail(email);
        if (user == null) {
            throw new IllegalArgumentException("User not found with the given email");
        }
        Role existingRole = user.getRole();

        user.setPassword(newPassword);
        user.setRole(existingRole);
        userDao.save(user);
    }
}
