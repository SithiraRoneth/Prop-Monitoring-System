/* Created By Sithira Roneth
 * Date :10/29/24
 * Time :10:29
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoringsystem.dto.impl;

import lk.ijse.propmonitoringsystem.dto.MonitoringLogStatus;
import lk.ijse.propmonitoringsystem.entity.impl.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonitoringLogDto implements MonitoringLogStatus {
    private String logCode;
    private String date;
    private User user;
}
