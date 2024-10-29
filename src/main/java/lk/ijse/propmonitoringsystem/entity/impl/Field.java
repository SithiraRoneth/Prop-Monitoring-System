/* Created By Sithira Roneth
 * Date :10/29/24
 * Time :10:31
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoringsystem.entity.impl;

import jakarta.persistence.*;
import lk.ijse.propmonitoringsystem.dto.impl.CropDto;
import lk.ijse.propmonitoringsystem.dto.impl.StaffDto;
import lk.ijse.propmonitoringsystem.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "field")
public class Field implements SuperEntity {
    @Id
    private String field_Code;
    private String fieldName;
    private String fieldLocation;
    private Double extendSizeOfTheField;

    @OneToMany(mappedBy = "field")
    private List<Crop> Field_Code;

    @OneToMany(mappedBy = "field")
    private List<StaffDetails> fieldCode;

    @OneToMany(mappedBy = "field")
    private List<FieldDetails> field_code;

    private String fieldImage1;
    private String fieldImage2;
}
