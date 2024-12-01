/* Created By Sithira Roneth
 * Date :10/29/24
 * Time :10:28
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoringsystem.dto.impl;

import lk.ijse.propmonitoringsystem.dto.FieldStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldDto implements FieldStatus {
    private String fieldCode;
    private String fieldName;
    private String fieldLocation;
    private String extendSizeOfTheField;
    private String fieldImage1;
    private String fieldImage2;
}
