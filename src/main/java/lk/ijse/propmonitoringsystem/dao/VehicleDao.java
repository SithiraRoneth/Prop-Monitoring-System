package lk.ijse.propmonitoringsystem.dao;

import lk.ijse.propmonitoringsystem.entity.impl.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleDao extends JpaRepository<Vehicle, String> {
//    @Query("SELECT v.vehicle_code FROM Vehicle v ORDER BY v.vehicleCode DESC")
    //String findLastVehicleCode();
}
