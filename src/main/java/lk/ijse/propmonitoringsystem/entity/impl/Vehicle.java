package lk.ijse.propmonitoringsystem.entity.impl;

import jakarta.persistence.*;
import lk.ijse.propmonitoringsystem.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vehicle")
public class Vehicle implements SuperEntity {
    @Id
    private String licensePlateNo;
    private String vehicleCategory;
    private String fuelType;
    private String status;
    private String remarks;

    @ManyToOne
    @JoinColumn(name = "staff", nullable = false)
    private Staff staff;
}
