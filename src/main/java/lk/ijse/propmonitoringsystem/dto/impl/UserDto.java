/* Created By Sithira Roneth
* Date :10/29/24
* Time :10:28
* Project Name :Prop-Monitoring-System 
* */
package lk.ijse.propmonitoringsystem.dto.impl;

import lk.ijse.propmonitoringsystem.dto.UserStatus;
import lk.ijse.propmonitoringsystem.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements UserStatus {
    private String email;
    private String password;
    private Role role;
}
