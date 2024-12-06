package lk.ijse.propmonitoringsystem.entity.impl;

import jakarta.persistence.*;
import lk.ijse.propmonitoringsystem.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "field")
public class Field implements SuperEntity {
    @Id
    private String fieldCode;
    private String fieldName;
    private String fieldLocation;
    private String extendSizeOfTheField;

    @OneToMany(mappedBy = "field")
    private List<FieldCropDetails> field_Code;

    @OneToMany(mappedBy = "field")
    private List<DutyManage> field_code;

    @Column(columnDefinition = "LONGTEXT")
    private String fieldImage1;

    @Column(columnDefinition = "LONGTEXT")
    private String fieldImage2;

    @OneToMany(mappedBy = "field")
    private List<EquipmentManage> Field_Code;

    public Field(String fieldCode){
        this.fieldCode = fieldCode;
    }
}
