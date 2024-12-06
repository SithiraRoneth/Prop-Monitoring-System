/* Created By Sithira Roneth
 * Date :11/21/24
 * Time :12:19
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoringsystem.Controller;

import lk.ijse.propmonitoringsystem.Service.FieldCropDetailsService;
import lk.ijse.propmonitoringsystem.dto.impl.FieldCropDetailsDto;
import lk.ijse.propmonitoringsystem.exception.DataPersistException;
import lk.ijse.propmonitoringsystem.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/fieldEquip")
public class FieldCropDetailsController {
    @Autowired
    private FieldCropDetailsService fieldEquipmentDetailsService;
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveFieldEquipmentDetails(
            @RequestPart("fieldEquipmentId") String fieldEquipId,
            @RequestPart("FieldId") String fieldId,
            @RequestPart("CropId") String cropId
    ) {
        try {
            FieldCropDetailsDto buildFieldEquip = new FieldCropDetailsDto();
            buildFieldEquip.setFieldDetailsId(AppUtil.generateFieldDetailsId());
            buildFieldEquip.setField(fieldId);
            buildFieldEquip.setCrop(cropId);
            fieldEquipmentDetailsService.saveFieldEquipmentDetails(buildFieldEquip);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FieldCropDetailsDto> getAllFieldEquipmentDetails() {
        return fieldEquipmentDetailsService.getAllFieldEquipmentDetails();
    }
}
