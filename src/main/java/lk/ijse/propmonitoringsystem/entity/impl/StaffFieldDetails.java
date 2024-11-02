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
@Table(name = "staffFieldDetails")
public class StaffFieldDetails implements SuperEntity {
    @Id
    private String staffDetails_id;

    @ManyToOne
    @JoinColumn(name = "staffId",nullable = false)
    private Staff staff;

    @ManyToOne
    @JoinColumn(name = "fieldCode",nullable = false)
    private Field field;
}
