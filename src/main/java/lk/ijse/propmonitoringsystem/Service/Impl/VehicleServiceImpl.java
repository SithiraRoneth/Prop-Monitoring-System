/* Created By Sithira Roneth
* Date :10/29/24
* Time :10:33
* Project Name :Prop-Monitoring-System 
* */
package lk.ijse.propmonitoringsystem.Service.Impl;

import jakarta.transaction.Transactional;
import lk.ijse.propmonitoringsystem.Service.VehicleService;
import lk.ijse.propmonitoringsystem.customStatusCode.SelectedErrorStatus;
import lk.ijse.propmonitoringsystem.dao.VehicleDao;
import lk.ijse.propmonitoringsystem.dto.VehicleStatus;
import lk.ijse.propmonitoringsystem.dto.impl.VehicleDto;
import lk.ijse.propmonitoringsystem.entity.impl.Vehicle;
import lk.ijse.propmonitoringsystem.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleDao vehicleDao;
    @Autowired
    private Mapping mapping;
    @Override
    public void saveVehicle(VehicleDto vehicleDto) {
        Vehicle savedVehicle = vehicleDao.save(mapping.toVehicleEntity(vehicleDto));
        if (savedVehicle == null){
            throw new RuntimeException("Save Vehicle Failed");
        }
    }
    @Override
    public VehicleStatus getSelectedVehicle(String vehicleCode) {
        if (vehicleDao.existsById(vehicleCode)){
            Vehicle selectedVehicle = vehicleDao.getReferenceById(vehicleCode);
            return mapping.toVehicleDto(selectedVehicle);
        }else {
            return new SelectedErrorStatus(2,"Vehicle with code" + vehicleCode + "notFound");
        }
    }
    @Override
    public List<VehicleDto> getAllVehicles() {
        List<Vehicle> allVehicle = vehicleDao.findAll();
        return mapping.toVehicleDtoList(allVehicle);
    }

    @Override
    public void updateVehicle(String vehicleCode, VehicleDto vehicleDto) {
        Optional<Vehicle> tempVehicle = vehicleDao.findById(vehicleCode);
        if (tempVehicle.isPresent()){
            Vehicle vehicle = tempVehicle.get();
           // vehicle.setVehicleCode(vehicleDto.getVehicleCode());
            vehicle.setLicensePlateNo(vehicleDto.getLicensePlateNo());
            vehicle.setVehicleCategory(vehicleDto.getVehicleCategory());
            vehicle.setFuelType(vehicleDto.getFuelType());
            vehicle.setStatus(vehicleDto.getStatus());
            vehicle.setRemarks(vehicleDto.getRemarks());
        }
    }

    @Override
    public void deleteVehicle(String vehicleCode) {
        Optional<Vehicle> existVehicle = vehicleDao.findById(vehicleCode);
        if (existVehicle.isPresent()){
            throw new RuntimeException("Delete Vehicle Failed");
        }else {
            vehicleDao.deleteById(vehicleCode);
        }
    }

    @Override
    public String generatedVehicleCode() {
        /*String lastCode = vehicleDao.findLastVehicleCode();
        String newCode;

        if (lastCode == null) {
            newCode = "Vehicle-001";
        } else {
            String[] parts = lastCode.split("-");
            int lastNumber = Integer.parseInt(parts[1]);
            int newNumber = lastNumber + 1;
            newCode = String.format("Vehicle-%03d", newNumber);
        }

        // Check if the code already exists in the database
        while (vehicleDao.existsByCode(newCode)) {
            String[] parts = newCode.split("-");
            int lastNumber = Integer.parseInt(parts[1]);
            int newNumber = lastNumber + 1;
            newCode = String.format("Vehicle-%03d", newNumber);
        }*/

        return null;
    }

}
