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
@Table(name="userStaffDetails")
public class UserStaffDetails implements SuperEntity {
    @Id
    private String userStaffId;
    private String role;

    @ManyToOne
    @JoinColumn(name = "username",nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "staffId",nullable = false)
    private Staff staff;
}
