/* Created By Sithira Roneth
 * Date :10/29/24
 * Time :10:26
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoringsystem.Controller;

import lk.ijse.propmonitoringsystem.Service.CropService;
import lk.ijse.propmonitoringsystem.dto.CropStatus;
import lk.ijse.propmonitoringsystem.dto.impl.CropDto;
import lk.ijse.propmonitoringsystem.exception.CropNotFoundException;
import lk.ijse.propmonitoringsystem.exception.DataPersistException;
import lk.ijse.propmonitoringsystem.util.AppUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("api/v1/crops")
public class CropController {
    @Autowired
    private CropService cropService;
    private final Logger logger = LoggerFactory.getLogger(CropController.class);

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveCrop(
            @RequestPart("crop_code") String cropCode,
            @RequestPart("cropName") String cropName,
            @RequestPart("scientificName") String scientificName,
            @RequestPart("cropImage") MultipartFile cropImage,
            @RequestPart("category") String category,
            @RequestPart("season") String season
    ) {

        System.out.println("cropImage" + cropImage);
        String bs64 = "";
        try {
            byte[] byteCrop = cropImage.getBytes();
            bs64 = AppUtil.generateProfilePicToBase64(byteCrop);

            //String generatedCode = cropService.generateCropCode();

            var buildCrop = new CropDto();
            buildCrop.setCropCode(cropCode);
            buildCrop.setCropName(cropName);
            buildCrop.setScientificName(scientificName);
            buildCrop.setCropImage(bs64);
            buildCrop.setCategory(category);
            buildCrop.setSeason(season);

            cropService.saveCrop(buildCrop);
            logger.info("Crop Saved");
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "{cropCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CropStatus getSelectedCrop(@PathVariable("cropCode") String cropCode) {
        return cropService.getSelectedCrop(cropCode);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "{crop-code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteCrop(@PathVariable("crop-code") String cropCode) {
        try {
            cropService.deleteCrop(cropCode);
            logger.info("crop deleted");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CropNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<CropDto> getAllCrops() {
//        return cropService.getAllCrops();
//    }

    public ResponseEntity<List<CropDto>> getAllCrops() {
        List<CropDto> crops = cropService.getAllCrops();
        crops.stream()
                .map(crop -> new CropDto(
                        crop.getCropCode(),
                        crop.getCropName(),
                        crop.getScientificName(),
                        crop.getCropImage(), // Assuming Base64-encoded image is stored directly
                        crop.getCategory(),
                        crop.getSeason()
                ))
                .collect(Collectors.toList());
        return ResponseEntity.ok(crops);
    }

    @PutMapping(value = "{crop_code}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void updateCrop(
            @RequestPart("cropCode") String cropCode,  // Ensure this is included
            @RequestPart("cropName") String cropName,
            @RequestPart("scientificName") String scientificName,
            @RequestPart("cropImage") MultipartFile cropImage,  // Ensure this is included
            @RequestPart("category") String category,
            @RequestPart("season") String season
    ) {
        if (cropImage == null) {
            throw new IllegalArgumentException("cropImage is required but was not provided.");
        }

        String bs64 = "";
        try {
            byte[] byteCrop = cropImage.getBytes();
            bs64 = AppUtil.generateProfilePicToBase64(byteCrop);
        } catch (IOException e) {
            e.printStackTrace();
        }

        var buildCrop = new CropDto();
        buildCrop.setCropName(cropName);
        buildCrop.setScientificName(scientificName);
        buildCrop.setCropImage(bs64);
        buildCrop.setCategory(category);
        buildCrop.setSeason(season);

        cropService.updateCrop(cropCode, buildCrop);// Pass the cropCode and updated crop data
        logger.info("crop updated");
    }


}
