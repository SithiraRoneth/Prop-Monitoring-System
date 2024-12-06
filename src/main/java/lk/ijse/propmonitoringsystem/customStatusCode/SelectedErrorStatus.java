/* Created By Sithira Roneth
 * Date :11/2/24
 * Time :10:43
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoringsystem.customStatusCode;

import lk.ijse.propmonitoringsystem.dto.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectedErrorStatus implements UserStatus,CropStatus, VehicleStatus, EquipmentStatus, FieldStatus, StaffStatus, MonitoringLogStatus {
    private int statusCode;
    private String status;
}
