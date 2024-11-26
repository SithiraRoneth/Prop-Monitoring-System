package lk.ijse.propmonitoringsystem.dao;

import lk.ijse.propmonitoringsystem.entity.impl.DutyManage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffFieldDetailsDao extends JpaRepository<DutyManage,String> {
}
