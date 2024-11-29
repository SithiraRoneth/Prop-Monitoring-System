/* Created By Sithira Roneth
 * Date :10/29/24
 * Time :10:27
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoringsystem.Controller;

import lk.ijse.propmonitoringsystem.Service.EquipmentService;
import lk.ijse.propmonitoringsystem.dto.EquipmentStatus;
import lk.ijse.propmonitoringsystem.dto.impl.EquipmentDto;
import lk.ijse.propmonitoringsystem.dto.impl.FieldDto;
import lk.ijse.propmonitoringsystem.dto.impl.StaffDto;
import lk.ijse.propmonitoringsystem.entity.Status;
import lk.ijse.propmonitoringsystem.entity.Type;
import lk.ijse.propmonitoringsystem.entity.impl.Equipment;
import lk.ijse.propmonitoringsystem.exception.DataPersistException;
import lk.ijse.propmonitoringsystem.exception.EquipmentNotFoundException;
import lk.ijse.propmonitoringsystem.exception.StaffNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/equipments")
public class EquipmentController {
    @Autowired
    private EquipmentService equipmentService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveEquipment(@RequestBody EquipmentDto equipmentDto) {
        try {
            var buildEquip = new EquipmentDto();

            buildEquip.setEquipmentId(equipmentDto.getEquipmentId());
            buildEquip.setEquipmentName(equipmentDto.getEquipmentName());
            buildEquip.setEquipmentType(Type.valueOf(String.valueOf(equipmentDto.getEquipmentType())));
            buildEquip.setStatus(Status.valueOf(String.valueOf(equipmentDto.getStatus())));
            System.out.println(buildEquip);
            equipmentService.saveEquipment(buildEquip);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "{equipmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EquipmentStatus getSelectedEquip(@PathVariable("equipmentId") String equipmentId) {
        return equipmentService.getSelectedEquipment(equipmentId);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EquipmentDto> getAllEquipments() {
        List<EquipmentDto> equipments = equipmentService.getAllEquipment();
        System.out.println("Equipments fetched: " + equipments);
        return equipments;
    }

    @PutMapping(value = "{equipmentId}" ,consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateEquipment(EquipmentDto equipmentDto,
                                @RequestPart("equipmentId") String equipmentId,
                                @RequestPart("equipmentName") String equipmentName,
                                @RequestPart("equipmentType") String equipmentType,
                                @RequestPart("status") String status

    ){
        try {
            var UpdateEquip = new EquipmentDto();
            UpdateEquip.setEquipmentId(equipmentId);
            UpdateEquip.setEquipmentName(equipmentName);
            UpdateEquip.setEquipmentType(Type.valueOf(equipmentType));
            UpdateEquip.setStatus(Status.valueOf(status));
            equipmentService.updateEquipment(equipmentId,UpdateEquip);
        }catch (Exception e){
            throw new RuntimeException("Equipment didn't updated");
        }
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "{equipmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteStaff(@PathVariable("equipmentId") String equipmentId) {
        try {
            equipmentService.deleteEquipment(equipmentId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Successful deletion
        } catch (StaffNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Staff not found
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // General error
        }
    }
}
