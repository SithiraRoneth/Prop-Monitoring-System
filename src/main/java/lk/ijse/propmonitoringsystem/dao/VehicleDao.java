package lk.ijse.propmonitoringsystem.dao;

import lk.ijse.propmonitoringsystem.entity.impl.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleDao extends JpaRepository<Vehicle, String> {
}
