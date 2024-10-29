/* Created By Sithira Roneth
* Date :10/29/24
* Time :10:29
* Project Name :Prop-Monitoring-System 
* */
package lk.ijse.propmonitoringsystem.dto.impl;

import lk.ijse.propmonitoringsystem.entity.Status;
import lk.ijse.propmonitoringsystem.entity.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentDto {
    private String equipmentId;
    private String equipmentName;
    private Type equipmentType;
    private Status status;
    private StaffDto staff;
    private FieldDto field;

}
