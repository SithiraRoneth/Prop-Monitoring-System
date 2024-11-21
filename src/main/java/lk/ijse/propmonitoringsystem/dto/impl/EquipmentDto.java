/* Created By Sithira Roneth
* Date :10/29/24
* Time :10:29
* Project Name :Prop-Monitoring-System 
* */
package lk.ijse.propmonitoringsystem.dto.impl;

import lk.ijse.propmonitoringsystem.dto.EquipmentStatus;
import lk.ijse.propmonitoringsystem.entity.Status;
import lk.ijse.propmonitoringsystem.entity.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentDto implements EquipmentStatus {
    private String equipmentId;
    private String equipmentName;
    private Type equipmentType;
    private Status status;
    private List<StaffDto> staff;
    private List<FieldDto> field;

}
