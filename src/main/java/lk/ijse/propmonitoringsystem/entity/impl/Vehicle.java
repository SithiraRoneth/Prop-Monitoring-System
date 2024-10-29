/* Created By Sithira Roneth
 * Date :10/29/24
 * Time :10:32
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoringsystem.entity.impl;

import jakarta.persistence.*;
import lk.ijse.propmonitoringsystem.dto.impl.StaffDto;
import lk.ijse.propmonitoringsystem.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vehicle")
public class Vehicle implements SuperEntity {
    @Id
    private String vehicleCode;
    private String licensePlateNo;
    private String vehicleCategory;
    private String fuelType;
    private String status;

//    @ManyToOne
//    @JoinColumn(name = "vehicle_Code",nullable = false)
//    private Staff staff;

    private String remarks;
}
