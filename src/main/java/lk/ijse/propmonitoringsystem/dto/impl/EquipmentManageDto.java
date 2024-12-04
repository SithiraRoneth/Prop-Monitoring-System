/* Created By Sithira Roneth
 * Date :11/21/24
 * Time :12:04
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoringsystem.dto.impl;

import lk.ijse.propmonitoringsystem.dto.EquipmentManageStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentManageDto implements EquipmentManageStatus {
    private String StaffEqId;
    private String StaffId;
    private String EqCode;
}
