/* Created By Sithira Roneth
 * Date :10/29/24
 * Time :13:14
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
@Table(name="equipmentDetails")
public class EquipmentDetails implements SuperEntity {
    @Id
    private String eqDetailsId;

    @ManyToOne
    @JoinColumn(name = "StaffId",nullable = false)
    private Staff staff;

    @ManyToOne
    @JoinColumn(name = "equipmentId",nullable = false)
    private Equipment equipment;
}
