/* Created By Sithira Roneth
* Date :10/29/24
* Time :10:29
* Project Name :Prop-Monitoring-System 
* */
package lk.ijse.propmonitoringsystem.dto.impl;

import lk.ijse.propmonitoringsystem.dto.VehicleStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDto implements VehicleStatus {
    private String licensePlateNo;
    private String vehicleCategory;
    private String fuelType;
    private String status;
    private StaffDto staffMemberDetails;
    private String remarks;
}
