package lk.ijse.propmonitoringsystem.dao;

import lk.ijse.propmonitoringsystem.entity.impl.StaffEquipmentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffEquipmentDao extends JpaRepository<StaffEquipmentDetails,String> {
}
