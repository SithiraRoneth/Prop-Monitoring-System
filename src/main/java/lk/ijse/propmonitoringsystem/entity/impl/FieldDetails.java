/* Created By Sithira Roneth
 * Date :10/29/24
 * Time :14:11
 * Project Name :Prop-Monitoring-System
 * */
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
@Table(name = "FieldDetails")
public class FieldDetails implements SuperEntity {
    @Id
    private String fieldDetailsId;
    @ManyToOne
    @JoinColumn(name = "filed_code", nullable = false)
    private Field field;
    @ManyToOne
    @JoinColumn(name = "equipment_id", nullable = false)
    private Equipment equipment;
}
