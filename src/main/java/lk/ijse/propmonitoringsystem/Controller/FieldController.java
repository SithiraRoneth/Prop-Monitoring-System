/* Created By Sithira Roneth
 * Date :10/29/24
 * Time :10:25
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoringsystem.Controller;

import lk.ijse.propmonitoringsystem.Service.FieldService;
import lk.ijse.propmonitoringsystem.dto.FieldStatus;
import lk.ijse.propmonitoringsystem.dto.impl.FieldDto;
import lk.ijse.propmonitoringsystem.entity.impl.Field;
import lk.ijse.propmonitoringsystem.exception.DataPersistException;
import lk.ijse.propmonitoringsystem.exception.FieldNotFoundException;
import lk.ijse.propmonitoringsystem.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/fields")
public class FieldController {
    @Autowired
    private FieldService fieldService;
//    private final Logger logger = LoggerFactory.getLogger(FieldController.class);

//    @GetMapping
//    public String FieldController() {
//        return "OK";
//    }
//
//    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Void> saveField(
//            @RequestPart("fieldCode") String fieldCode,
//            @RequestPart("fieldName") String fieldName,
//            @RequestPart("fieldLocation") Point fieldLocation,
//            @RequestPart("extendSizeOfTheField") Double extendSizeOfTheField,
//            @RequestPart("fieldImage1") MultipartFile fieldImage1,
//            @RequestPart("fieldImage2") MultipartFile fieldImage2
//    ) {
//        System.out.println("ava");
//        String b1 = "";
//        String b2 = "";
//        try {
//            byte[] image1 = fieldImage1.getBytes();
//            byte[] image2 = fieldImage2.getBytes();
//            b1 = AppUtil.generateProfilePicToBase64(image1);
//            b2 = AppUtil.generateProfilePicToBase64(image2);
//
//            var buildField = new FieldDto();
//            buildField.setFieldCode(fieldCode);
//            buildField.setFieldName(fieldName);
//            buildField.setFieldLocation(fieldLocation);
//            buildField.setExtendSizeOfTheField(extendSizeOfTheField);
//            buildField.setFieldImage1(b1);
//            buildField.setFieldImage2(b2);
//            System.out.println(buildField);
//
//            fieldService.saveField(buildField);
//            logger.info("Field Saved");
//            return new ResponseEntity<>(HttpStatus.CREATED);
//        } catch (DataPersistException e) {
//            System.out.println("ava");
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FieldDto> createField(@RequestBody FieldDto fieldDto) throws DataPersistException {
        try {
            var buildField = new FieldDto();

            buildField.setFieldCode(fieldDto.getFieldCode());
            buildField.setFieldName(fieldDto.getFieldName());
            buildField.setFieldLocation(fieldDto.getFieldLocation());
            buildField.setExtendSizeOfTheField(fieldDto.getExtendSizeOfTheField());
            buildField.setFieldImage1(fieldDto.getFieldImage1());
            buildField.setFieldImage2(fieldDto.getFieldImage2());
            fieldService.saveField(buildField);
            return new ResponseEntity<>(buildField, HttpStatus.CREATED);
        } catch (DataPersistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "{fieldCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public FieldStatus getSelectedField(@PathVariable("fieldCode") String fieldCode) {
        return fieldService.getSelectedField(fieldCode);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FieldDto> getAllFields() {
        return fieldService.getAllFields();
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

    @PutMapping(value = "{fieldCode}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateField(FieldDto fieldDto,
                            @RequestPart("fieldCode") String fieldCode,
                            @RequestPart("fieldName") String fieldName,
                            @RequestPart("fieldLocation") Point fieldLocation,
                            @RequestPart("extendSizeOfTheField") Double extendSizeOfTheField,
                            @RequestPart("fieldImage1") MultipartFile fieldImage1,
                            @RequestPart("fieldImage2") MultipartFile fieldImage2
    ) {
        String base1 = "";
        String base2 = "";
        try {
            byte[] byte1 = fieldImage1.getBytes();
            byte[] byte2 = fieldImage2.getBytes();
            base1 = AppUtil.generateProfilePicToBase64(byte1);
            base2 = AppUtil.generateProfilePicToBase64(byte2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        var buildField = new FieldDto();
        buildField.setFieldCode(fieldCode);
        buildField.setFieldName(fieldName);
        buildField.setFieldLocation(fieldLocation);
        buildField.setExtendSizeOfTheField(extendSizeOfTheField);
        buildField.setFieldImage1(base1);
        buildField.setFieldImage2(base2);

        fieldService.updateField(fieldCode,buildField);
    }
}

