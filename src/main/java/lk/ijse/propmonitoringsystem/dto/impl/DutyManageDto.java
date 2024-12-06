/* Created By Sithira Roneth
 * Date :12/4/24
 * Time :08:18
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoringsystem.dto.impl;

import lk.ijse.propmonitoringsystem.dto.DutyManageStatus;
import lk.ijse.propmonitoringsystem.entity.impl.Field;
import lk.ijse.propmonitoringsystem.entity.impl.Staff;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DutyManageDto implements DutyManageStatus {
    private String duty_id;
    private String date;
    private String timePeriod;
    private String duty;
    private String staff_email;
    private String field_code;
}
