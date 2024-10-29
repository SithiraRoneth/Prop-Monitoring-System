/* Created By Sithira Roneth
 * Date :10/29/24
 * Time :10:29
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoringsystem.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonitoringLogDto {
    private String logCode;
    private Date date;
    private String logDetails;
    private String observedImage;
    private List<FieldDto> fields;
    private List<CropDto> crops;
    private List<StaffDto> staffs;
}
