package lk.ijse.propmonitoringsystem.entity.impl;

import jakarta.persistence.*;
import lk.ijse.propmonitoringsystem.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EquipmentManage")
public class EquipmentManage implements SuperEntity {
    @Id
    private String EqManageId;

    @ManyToOne
    @JoinColumn(name = "Field_Code", nullable = false)
    private Field field;

    @ManyToOne
    @JoinColumn(name = "equipment_Id", nullable = false)
    private Equipment equipment;

    @ManyToOne
    @JoinColumn(name = "staff_id", nullable = false)
    private Staff staff;
}