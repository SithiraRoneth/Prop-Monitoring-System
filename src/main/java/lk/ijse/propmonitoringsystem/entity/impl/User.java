/* Created By Sithira Roneth
 * Date :10/29/24
 * Time :10:31
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoringsystem.entity.impl;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lk.ijse.propmonitoringsystem.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String email;
    private String password;
    private Role role;
}
