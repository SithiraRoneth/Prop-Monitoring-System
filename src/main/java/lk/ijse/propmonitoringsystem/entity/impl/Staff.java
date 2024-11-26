/* Created By Sithira Roneth
 * Date :10/29/24
 * Time :10:32
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoringsystem.entity.impl;

import jakarta.persistence.*;
import lk.ijse.propmonitoringsystem.entity.Gender;
import lk.ijse.propmonitoringsystem.entity.Role;
import lk.ijse.propmonitoringsystem.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "staff")
public class Staff implements SuperEntity {
    @Id
    private String staff_id;
    private String firstName;
    private String lastName;
    private String designation;
    private Gender gender;
    private Date joinedDate;
    private Date Dob;
    private String addressLine1;
    private String contactNo;
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "staff")
    private List<StaffFieldDetails> staffId;

//    @OneToMany(mappedBy = "vehicle")
//    private List<Vehicle> vehicle_Code;
}
