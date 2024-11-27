package lk.ijse.propmonitoringsystem.entity.impl;

import jakarta.persistence.*;
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
    private String fieldCode;
    private String fieldName;
    private Point fieldLocation;
    private Double extendSizeOfTheField;

    @OneToMany(mappedBy = "field")
    private List<CropFieldDetails> field_Code;

    @Column(columnDefinition = "LONGTEXT")
    private String fieldImage1;

    @Column(columnDefinition = "LONGTEXT")
    private String fieldImage2;

    @OneToMany(mappedBy = "field")
    private List<EquipmentManage> Field_Code;
}
