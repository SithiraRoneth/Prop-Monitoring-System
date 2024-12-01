/* Created By Sithira Roneth
 * Date :10/29/24
 * Time :10:25
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoringsystem.Controller;

import lk.ijse.propmonitoringsystem.Service.FieldService;
import lk.ijse.propmonitoringsystem.dto.FieldStatus;
import lk.ijse.propmonitoringsystem.dto.impl.CropDto;
import lk.ijse.propmonitoringsystem.dto.impl.FieldDto;
import lk.ijse.propmonitoringsystem.entity.impl.Field;
import lk.ijse.propmonitoringsystem.exception.DataPersistException;
import lk.ijse.propmonitoringsystem.exception.FieldNotFoundException;
import lk.ijse.propmonitoringsystem.util.AppUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("api/v1/fields")
public class FieldController {
    @Autowired
    private FieldService fieldService;
    private final Logger logger = LoggerFactory.getLogger(FieldController.class);

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveField(
            @RequestPart("fieldCode") String fieldCode,
            @RequestPart("fieldName") String fieldName,
            @RequestPart("fieldLocation") String fieldLocation,
            @RequestPart("extendSizeOfTheField") String extendSizeOfTheField,
            @RequestPart(value = "fieldImage1", required = false) MultipartFile fieldImage1,
            @RequestPart(value = "fieldImage2", required = false) MultipartFile fieldImage2
    ) {
        logger.info("Received fieldCode: {}, fieldName: {}, fieldLocation: {}, extendSizeOfTheField: {}",
                fieldCode, fieldName, fieldLocation, extendSizeOfTheField);
        try {
            // Handle file conversion if files are present
            String b1 = (fieldImage1 != null) ? AppUtil.generateProfilePicToBase64(fieldImage1.getBytes()) : null;
            String b2 = (fieldImage2 != null) ? AppUtil.generateProfilePicToBase64(fieldImage2.getBytes()) : null;

            // Build DTO
            FieldDto buildField = new FieldDto();
            buildField.setFieldCode(fieldCode);
            buildField.setFieldName(fieldName);
            buildField.setFieldLocation(fieldLocation);
            buildField.setExtendSizeOfTheField(extendSizeOfTheField);
            buildField.setFieldImage1(b1);
            buildField.setFieldImage2(b2);

            logger.info("Saving field: {}", buildField);
            fieldService.saveField(buildField);

            logger.info("Field saved successfully!");
            return new ResponseEntity<>(HttpStatus.CREATED);

        } catch (DataPersistException e) {
            logger.error("Data persistence error:", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            logger.error("Unexpected error:", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<FieldDto> createField(@RequestBody FieldDto fieldDto) throws DataPersistException {
//        try {
//            var buildField = new FieldDto();
//
//            buildField.setFieldCode(fieldDto.getFieldCode());
//            buildField.setFieldName(fieldDto.getFieldName());
//            buildField.setFieldLocation(fieldDto.getFieldLocation());
//            buildField.setExtendSizeOfTheField(fieldDto.getExtendSizeOfTheField());
//            buildField.setFieldImage1(fieldDto.getFieldImage1());
//            buildField.setFieldImage2(fieldDto.getFieldImage2());
//            fieldService.saveField(buildField);
//            return new ResponseEntity<>(buildField, HttpStatus.CREATED);
//        } catch (DataPersistException e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
    @GetMapping(value = "{fieldCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public FieldStatus getSelectedField(@PathVariable("fieldCode") String fieldCode) {
        return fieldService.getSelectedField(fieldCode);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FieldDto>> getAllCrops() {
        List<FieldDto> fields = fieldService.getAllFields();
        fields.stream()
                .map(field -> new FieldDto(
                        field.getFieldCode(),
                        field.getFieldName(),
                        field.getFieldLocation(),
                        field.getExtendSizeOfTheField(), // Assuming Base64-encoded image is stored directly
                        field.getFieldImage1(),
                        field.getFieldImage2()
                ))
                .collect(Collectors.toList());
        return ResponseEntity.ok(fields);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "{filedCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteField(@PathVariable("filedCode") String fieldCode) {
        try {
            fieldService.deleteField(fieldCode);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (FieldNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

        @PutMapping(value = "{fieldCode}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
        public ResponseEntity<?> updateField(
                @PathVariable("fieldCode") String fieldCode,
                @RequestParam("fieldName") String fieldName,
                @RequestParam("fieldLocation") String fieldLocation,
                @RequestParam("extendSizeOfTheField") String extendSizeOfTheField,
                @RequestPart(value = "fieldImage1", required = false) MultipartFile fieldImage1,
                @RequestPart(value = "fieldImage2", required = false) MultipartFile fieldImage2
        ) {
            String base1 = "";
            String base2 = "";
            try {
                if (fieldImage1 != null) {
                    byte[] byte1 = fieldImage1.getBytes();
                    base1 = AppUtil.generateProfilePicToBase64(byte1);
                }
                if (fieldImage2 != null) {
                    byte[] byte2 = fieldImage2.getBytes();
                    base2 = AppUtil.generateProfilePicToBase64(byte2);
                }
            } catch (IOException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing images.");
            }

            FieldDto buildField = new FieldDto();
            buildField.setFieldCode(fieldCode);
            buildField.setFieldName(fieldName);
            buildField.setFieldLocation(fieldLocation);
            buildField.setExtendSizeOfTheField(extendSizeOfTheField);
            buildField.setFieldImage1(base1);
            buildField.setFieldImage2(base2);

            fieldService.updateField(fieldCode, buildField);
            return ResponseEntity.ok("Field updated successfully.");
        }

}

