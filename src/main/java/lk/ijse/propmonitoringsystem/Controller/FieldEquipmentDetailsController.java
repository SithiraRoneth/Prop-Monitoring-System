/* Created By Sithira Roneth
 * Date :11/21/24
 * Time :12:19
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoringsystem.Controller;

import lk.ijse.propmonitoringsystem.Service.FieldEquipmentDetailsService;
import lk.ijse.propmonitoringsystem.dto.impl.FieldEquipmentDetailsDto;
import lk.ijse.propmonitoringsystem.exception.DataPersistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/fieldEquip")
public class FieldEquipmentDetailsController {
    @Autowired
    private FieldEquipmentDetailsService fieldEquipmentDetailsService;
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveFieldEquipmentDetails(
            @RequestPart("fieldEquipmentId") String fieldEquipId,
            @RequestPart("FieldId") String fieldId,
            @RequestPart("EquipmentId") String equipmentId
    ) {
        try {
            FieldEquipmentDetailsDto buildFieldEquip = new FieldEquipmentDetailsDto();
            buildFieldEquip.setFieldDetailsId(fieldEquipId);
            buildFieldEquip.setField(fieldId);
            buildFieldEquip.setEquipment(equipmentId);
            fieldEquipmentDetailsService.saveFieldEquipmentDetails(buildFieldEquip);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FieldEquipmentDetailsDto> getAllFieldEquipmentDetails() {
        return fieldEquipmentDetailsService.getAllFieldEquipmentDetails();
    }
}
