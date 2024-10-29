/* Created By Sithira Roneth
 * Date :10/29/24
 * Time :11:37
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
@Table(name = "staffDetails")
public class StaffDetails implements SuperEntity {
    @Id
    private String staffDetails_id;

    @ManyToOne
    @JoinColumn(name = "staffId",nullable = false)
    private Staff staff;

    @ManyToOne
    @JoinColumn(name = "fieldCode",nullable = false)
    private Field field;
}
