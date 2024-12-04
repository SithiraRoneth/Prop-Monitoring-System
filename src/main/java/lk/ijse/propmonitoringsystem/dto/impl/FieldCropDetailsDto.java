/* Created By Sithira Roneth
 * Date :11/21/24
 * Time :11:54
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoringsystem.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldCropDetailsDto {
    private String fieldDetailsId;
    private String field;
    private String crop;
}
