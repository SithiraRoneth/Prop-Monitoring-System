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
@Table(name="equipmentDetails")
public class StaffEquipmentDetails implements SuperEntity {
    @Id
    private String eqDetailsId;

    @ManyToOne
    @JoinColumn(name = "StaffId",nullable = false)
    private Staff staff;

    @ManyToOne
    @JoinColumn(name = "equipmentId",nullable = false)
    private Equipment equipment;
}
