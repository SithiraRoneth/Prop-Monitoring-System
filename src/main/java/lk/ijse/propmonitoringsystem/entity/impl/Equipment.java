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
    private String equipmentId;
    private String equipmentName;

    @Enumerated(EnumType.STRING)
    private Type equipmentType;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "equipment")
    private List<EquipmentManage> equipment_Id;

//    @OneToMany(mappedBy = "equipment")
//    private List<StaffEquipmentDetails> equipment_id;

}
