/* Created By Sithira Roneth
* Date :10/29/24
* Time :10:27
* Project Name :Prop-Monitoring-System 
* */
package lk.ijse.propmonitoringsystem.Controller;

import lk.ijse.propmonitoringsystem.Service.VehicleService;
import lk.ijse.propmonitoringsystem.dto.VehicleStatus;
import lk.ijse.propmonitoringsystem.dto.impl.VehicleDto;
import lk.ijse.propmonitoringsystem.exception.DataPersistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveVehicle(@RequestBody VehicleDto vehicleDto){
        try {
            var buildVehicle = new VehicleDto();
            buildVehicle.setVehicleCode(vehicleDto.getVehicleCode());
            buildVehicle.setLicensePlateNo(vehicleDto.getLicensePlateNo());
            buildVehicle.setVehicleCategory(vehicleDto.getVehicleCategory());
            buildVehicle.setFuelType(vehicleDto.getFuelType());
            buildVehicle.setStatus(vehicleDto.getStatus());
            buildVehicle.setStaffMemberDetails(vehicleDto.getStaffMemberDetails());
            buildVehicle.setRemarks(vehicleDto.getRemarks());

            vehicleService.saveVehicle(buildVehicle);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "vehicleCode" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public VehicleStatus getSelectedVehicle(@PathVariable("vehicleCode") String vehicleCode){
        return vehicleService.getSelectedVehicle(vehicleCode);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<VehicleDto> getVehicles(){
        return vehicleService.getAllVehicles();
    }
    @PutMapping(value = "vehicleCode",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateVehicle(@PathVariable("vehicleCode") String vehicleCode, @RequestBody VehicleDto vehicleDto){
        try {
            vehicleService.updateVehicle(vehicleCode,vehicleDto);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
