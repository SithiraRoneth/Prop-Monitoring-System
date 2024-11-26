package lk.ijse.propmonitoringsystem.entity.impl;

import jakarta.persistence.*;
import lk.ijse.propmonitoringsystem.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="monitoringLog")
public class MonitoringLog implements SuperEntity {
    @Id
    private String logCode;
    private Date date;
    private String logDetails;
    private String observedImage;

//    @OneToMany(mappedBy = "monitoringLog")
//    private List<UserMonitoringLogDetails> lod_code;

    @ManyToOne
    @JoinColumn(name = "userId",nullable = false)
    private User user;
}
