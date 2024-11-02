/* Created By Sithira Roneth
* Date :10/29/24
* Time :10:26
* Project Name :Prop-Monitoring-System 
* */
package lk.ijse.propmonitoringsystem.Controller;

import lk.ijse.propmonitoringsystem.Service.CropService;
import lk.ijse.propmonitoringsystem.dto.CropStatus;
import lk.ijse.propmonitoringsystem.dto.impl.CropDto;
import lk.ijse.propmonitoringsystem.dto.impl.FieldDto;
import lk.ijse.propmonitoringsystem.exception.CropNotFoundException;
import lk.ijse.propmonitoringsystem.exception.DataPersistException;
import lk.ijse.propmonitoringsystem.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/crops")
public class CropController {
    @Autowired
    private CropService cropService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveCrop(
            @RequestPart("cropCode") String cropCode,
            @RequestPart("cropName") String cropName,
            @RequestPart("scientificName") String scientificName,
            @RequestPart("cropImage") MultipartFile cropImage,
            @RequestPart("category") String category,
            @RequestPart("season") String season,
            @RequestPart("field") FieldDto field
    ) {
        System.out.println("cropImage" + cropImage);
        String bs64 = "";
        try {
            byte[] byteCrop = cropImage.getBytes();
            bs64 = AppUtil.generateProfilePicToBase64(byteCrop);

            var buildCrop = new CropDto();
            buildCrop.setCropCode(cropCode);
            buildCrop.setCropName(cropName);
            buildCrop.setScientificName(scientificName);
            buildCrop.setCropImage(bs64);
            buildCrop.setCategory(category);
            buildCrop.setSeason(season);
            buildCrop.setField(field);

            cropService.saveCrop(buildCrop);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "{cropCode}",produces = MediaType.APPLICATION_JSON_VALUE)
    public CropStatus getSelectedCrop(@PathVariable("cropCode") String cropCode) {
        return cropService.getSelectedCrop(cropCode);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "cropCode", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteCrop(@PathVariable("cropCode") String cropCode) {
        try {
            cropService.deleteCrop(cropCode);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (CropNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CropDto> getAllCrops() {
        return cropService.getAllCrops();
    }
    @PutMapping(value = "{crop_code}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void updateCrop(CropDto cropDto,
            @RequestPart("cropCode") String cropCode,
            @RequestPart("cropName") String cropName,
            @RequestPart("scientificName") String scientificName,
            @RequestPart("cropImage") MultipartFile cropImage,
            @RequestPart("category") String category,
            @RequestPart("season") String season,
            @RequestPart("field") FieldDto field
    ) {
        System.out.println("cropImage" + cropImage);
        String bs64 = "";
        try {
            byte[] byteCrop = cropImage.getBytes();
            bs64 = AppUtil.generateProfilePicToBase64(byteCrop);

        }catch (IOException e){
            e.printStackTrace();
        }

        var buildCrop = new CropDto();
        buildCrop.setCropCode(cropCode);
        buildCrop.setCropName(cropName);
        buildCrop.setScientificName(scientificName);
        buildCrop.setCropImage(bs64);
        buildCrop.setCategory(category);
        buildCrop.setSeason(season);
        buildCrop.setField(field);

        cropService.updateCrop(cropCode,buildCrop);
    }
}
