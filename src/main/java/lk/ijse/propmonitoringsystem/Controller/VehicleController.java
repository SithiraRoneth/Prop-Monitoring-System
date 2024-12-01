/* Created By Sithira Roneth
 * Date :10/29/24
 * Time :10:27
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoringsystem.Controller;

import lk.ijse.propmonitoringsystem.Service.VehicleService;
import lk.ijse.propmonitoringsystem.dto.VehicleStatus;
import lk.ijse.propmonitoringsystem.dto.impl.EquipmentDto;
import lk.ijse.propmonitoringsystem.dto.impl.VehicleDto;
import lk.ijse.propmonitoringsystem.exception.DataPersistException;
import lk.ijse.propmonitoringsystem.exception.StaffNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;
    private final Logger log = LoggerFactory.getLogger(VehicleController.class);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveVehicle(@RequestBody VehicleDto vehicleDto) {
        try {
            // Logging for debugging
            log.info("Received Vehicle Data: {}", vehicleDto);

            // Validate input
            if (vehicleDto.getLicensePlateNo() == null || vehicleDto.getLicensePlateNo().isEmpty()) {
                log.error("License plate number is missing.");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            // Save the vehicle
            var buildStaff = new VehicleDto();
            buildStaff.setLicensePlateNo(vehicleDto.getLicensePlateNo());
            buildStaff.setVehicleCategory(vehicleDto.getVehicleCategory());
            buildStaff.setFuelType(vehicleDto.getFuelType());
            buildStaff.setStatus(vehicleDto.getStatus());
            buildStaff.setStaffMemberDetails(vehicleDto.getStaffMemberDetails());
            buildStaff.setRemarks(vehicleDto.getRemarks());

            vehicleService.saveVehicle(buildStaff);
            log.info("Vehicle saved successfully.");

            return new ResponseEntity<>(HttpStatus.CREATED);

        } catch (DataPersistException e) {
            log.error("Failed to persist vehicle data: ", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            log.error("An unexpected error occurred: ", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping(value = "{licensePlateNo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public VehicleStatus getSelectedVehicle(@PathVariable("licensePlateNo") String licensePlateNo) {
        return vehicleService.getSelectedVehicle(licensePlateNo);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<VehicleDto> getVehicles() {
        List<VehicleDto> allVehicles = vehicleService.getAllVehicles();
        System.out.println("Vehicle fetched: " + allVehicles);
        return allVehicles;
    }
    @PutMapping(value = "{licensePlateNo}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateVehicle(@PathVariable("licensePlateNo") String licensePlateNo, @RequestBody VehicleDto vehicleDto) {
        try {
            vehicleService.updateVehicle(licensePlateNo, vehicleDto);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "{licensePlateNo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteVehicle(@PathVariable("licensePlateNo") String licensePlateNo) {
        try {
            vehicleService.deleteVehicle(licensePlateNo);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Successful deletion
        } catch (StaffNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Vehicle not found
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // General error
        }
    }
}
