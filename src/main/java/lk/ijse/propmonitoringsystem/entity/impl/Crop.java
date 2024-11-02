/* Created By Sithira Roneth
 * Date :10/29/24
 * Time :10:31
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoringsystem.entity.impl;

import jakarta.persistence.*;
import lk.ijse.propmonitoringsystem.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "crop")
public class Crop implements SuperEntity {
    @Id
    private String cropCode;
    private String cropName;
    private String scientificName;
    private String cropImage;
    private String category;
    private String season;

    @ManyToOne
    @JoinColumn(name = "Field_Code",nullable = false)
    private Field field;

}
