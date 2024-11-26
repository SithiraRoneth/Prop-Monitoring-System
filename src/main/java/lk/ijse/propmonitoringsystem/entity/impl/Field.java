package lk.ijse.propmonitoringsystem.entity.impl;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
    private String field_Code;
    private String fieldName;
    private String fieldLocation;
    private Double extendSizeOfTheField;

    @OneToMany(mappedBy = "field")
    private List<CropFieldDetails> fieldCode;

    private String fieldImage1;
    private String fieldImage2;

    @OneToMany(mappedBy = "field")
    private List<EquipmentManage> Field_Code;
}
