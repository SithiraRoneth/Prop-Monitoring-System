package lk.ijse.propmonitoringsystem.entity.impl;

import jakarta.persistence.*;
import lk.ijse.propmonitoringsystem.entity.Status;
import lk.ijse.propmonitoringsystem.entity.SuperEntity;
import lk.ijse.propmonitoringsystem.entity.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "equipment")
public class Equipment implements SuperEntity {
    @Id
    private String eqId;
    private String equipmentName;

    @Enumerated(EnumType.STRING)
    private Type equipmentType;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "equipment")
    private List<FieldEquipmentDetails> field;

    @OneToMany(mappedBy = "equipment")
    private List<StaffEquipmentDetails> equipment_id;

//    @OneToMany(mappedBy = "equipment")
//    private List<UserEquipmentDetails> equipment_code;
}
