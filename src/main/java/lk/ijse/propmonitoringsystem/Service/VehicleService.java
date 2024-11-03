package lk.ijse.propmonitoringsystem.Service;

import lk.ijse.propmonitoringsystem.dto.VehicleStatus;
import lk.ijse.propmonitoringsystem.dto.impl.VehicleDto;

import java.util.List;

public interface VehicleService {
    void saveVehicle(VehicleDto vehicleDto);
    VehicleStatus getSelectedVehicle(String vehicleCode);
    List<VehicleDto> getAllVehicles();
    void updateVehicle(String vehicleCode,VehicleDto vehicleDto);
    void deleteVehicle(String vehicleCode);
}
