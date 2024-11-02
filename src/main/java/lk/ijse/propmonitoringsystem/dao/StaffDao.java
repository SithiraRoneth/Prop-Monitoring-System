package lk.ijse.propmonitoringsystem.dao;

import lk.ijse.propmonitoringsystem.entity.impl.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffDao extends JpaRepository<Staff, String> {
}
