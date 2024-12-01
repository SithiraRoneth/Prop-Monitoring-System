/* Created By Sithira Roneth
* Date :10/29/24
* Time :10:29
* Project Name :Prop-Monitoring-System 
* */
package lk.ijse.propmonitoringsystem.dto.impl;

import lk.ijse.propmonitoringsystem.dto.StaffStatus;
import lk.ijse.propmonitoringsystem.entity.Gender;
import lk.ijse.propmonitoringsystem.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.StringReader;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffDto implements StaffStatus {
    private String email;
    private String firstName;
    private String lastName;
    private String designation;
    private String gender;
    private Date joinedDate;
    //private Date Dob;
    private String address;
    private String contactNo;
    private Role role;
}
