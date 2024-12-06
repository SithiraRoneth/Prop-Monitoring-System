/* Created By Sithira Roneth
* Date :10/29/24
* Time :10:35
* Project Name :Prop-Monitoring-System 
* */
package lk.ijse.propmonitoringsystem.Service;

import lk.ijse.propmonitoringsystem.dto.EquipmentStatus;
import lk.ijse.propmonitoringsystem.dto.UserStatus;
import lk.ijse.propmonitoringsystem.dto.impl.UserDto;

public interface UserService {
    UserStatus getSelectedUser(String email);
    void userSave(UserDto userDto);
    String getRoleByEmail(String email);
    boolean validateUser(String email, String password);
    void updateUser(String email,String newPassword);
}
