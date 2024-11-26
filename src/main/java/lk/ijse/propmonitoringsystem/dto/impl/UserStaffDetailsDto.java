/* Created By Sithira Roneth
 * Date :11/26/24
 * Time :09:49
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoringsystem.dto.impl;

import lk.ijse.propmonitoringsystem.dto.UserStaffDetailsStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserStaffDetailsDto implements UserStaffDetailsStatus {
    private String userStaffId;
    private String UserId;
    private String StaffId;
    private String Role;
}
