/* Created By Sithira Roneth
 * Date :10/29/24
 * Time :10:32
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoringsystem.entity.impl;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
    private Type equipmentType;
    private Status status;

    @OneToMany(mappedBy = "equipment")
    private List<FieldDetails> field;

    @OneToMany(mappedBy = "equipment")
    private List<EquipmentDetails>equipment_id;

}
