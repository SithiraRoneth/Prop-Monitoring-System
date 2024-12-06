/* Created By Sithira Roneth
 * Date :10/29/24
 * Time :10:31
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoringsystem.entity.impl;

import jakarta.persistence.*;
import lk.ijse.propmonitoringsystem.entity.Role;
import lk.ijse.propmonitoringsystem.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User implements SuperEntity {
    @Id
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<MonitoringLog> moniLogId;

//    @OneToMany(mappedBy = "user")
////    private List<UserFieldDetails> user_name;
////
////    @OneToMany(mappedBy = "user")
////    private List<UserFieldDetails> user_Name;
////
////    @OneToMany(mappedBy = "user")
////    private List<UserFieldDetails> username;

    public User(String email){
        this.email = email;
    }
}
