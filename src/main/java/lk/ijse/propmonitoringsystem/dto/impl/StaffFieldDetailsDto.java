/* Created By Sithira Roneth
 * Date :11/21/24
 * Time :12:11
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoringsystem.dto.impl;

import lk.ijse.propmonitoringsystem.dto.StaffFieldDetailsStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffFieldDetailsDto implements StaffFieldDetailsStatus {
    private String StaffFieldId;
    private String StaffId;
    private String FieldCode;
}
