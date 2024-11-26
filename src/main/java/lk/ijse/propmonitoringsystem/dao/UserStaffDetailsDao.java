package lk.ijse.propmonitoringsystem.dao;

import lk.ijse.propmonitoringsystem.entity.impl.UserStaffDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserStaffDetailsDao extends JpaRepository<UserStaffDetails,String> {
}
