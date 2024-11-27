/* Created By Sithira Roneth
 * Date :11/26/24
 * Time :11:57
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoringsystem.entity.impl;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cropFieldDetails")
public class CropFieldDetails {
    @Id
    private String cropFieldId;

    @ManyToOne
    @JoinColumn(name = "filed_Code", nullable = false)
    private Field field;

    @ManyToOne
    @JoinColumn(name = "crop_Code", nullable = false)
    private Crop crop;
}
