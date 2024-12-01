package lk.ijse.propmonitoringsystem.entity.impl;

import jakarta.persistence.*;
import lk.ijse.propmonitoringsystem.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DutyManage")
public class DutyManage implements SuperEntity {
    @Id
    private String duty_id;
    private Date date;
    private String timePeriod;
    private String duty;

    @ManyToOne
    @JoinColumn(name = "staff_email",nullable = false)
    private Staff staff;

    @ManyToOne
    @JoinColumn(name = "fieldCode",nullable = false)
    private Field field;
}
