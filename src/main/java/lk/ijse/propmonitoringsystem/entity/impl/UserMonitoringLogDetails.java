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
@Table(name="userMonitoringLogDetails")
public class UserMonitoringLogDetails implements SuperEntity {
    @Id
    private String userMoniterId;

    @ManyToOne
    @JoinColumn(name = "username",nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "lod_code",nullable = false)
    private MonitoringLog monitoringLog;
}
