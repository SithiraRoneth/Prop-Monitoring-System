/* Created By Sithira Roneth
* Date :10/29/24
* Time :10:33
* Project Name :Prop-Monitoring-System 
* */
package lk.ijse.propmonitoringsystem.Service.Impl;

import jakarta.transaction.Transactional;
import lk.ijse.propmonitoringsystem.Service.CropService;
import lk.ijse.propmonitoringsystem.customStatusCode.SelectedErrorStatus;
import lk.ijse.propmonitoringsystem.dao.CropDao;
import lk.ijse.propmonitoringsystem.dto.CropStatus;
import lk.ijse.propmonitoringsystem.dto.impl.CropDto;
import lk.ijse.propmonitoringsystem.dto.impl.FieldDto;
import lk.ijse.propmonitoringsystem.entity.impl.Crop;
import lk.ijse.propmonitoringsystem.entity.impl.Field;
import lk.ijse.propmonitoringsystem.exception.CropNotFoundException;
import lk.ijse.propmonitoringsystem.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CropServiceImpl implements CropService {
    @Autowired
    private CropDao cropDao;
    @Autowired
    private Mapping mapping;
    @Override
    public void saveCrop(CropDto cropDto) {
//        System.out.println("crop service"+cropDto);
        Crop savedCrop = cropDao.save(mapping.toCropEntity(cropDto));
        System.out.println("hfgdjyfu"+savedCrop);
        if (savedCrop == null){
            throw new RuntimeException("Save crop failed");
        }
    }

    @Override
    public CropStatus getSelectedCrop(String cropCode) {
        if (cropDao.existsById(cropCode)){
            Crop selectedCrop = cropDao.getReferenceById(cropCode);
            return mapping.toCropDto(selectedCrop);
        }else {
            return new SelectedErrorStatus(2,"Crop with code " + cropCode + " not found");
        }
    }

    @Override
    public List<CropDto> getAllCrops() {
        List<Crop> allCrops = cropDao.findAll();
        return mapping.toCropDtoList(allCrops);
    }

    @Override
    public void deleteCrop(String cropCode) {
        Optional<Crop> existCrop = cropDao.findById(cropCode);
        if (existCrop.isEmpty()) { // Check if crop is NOT found
            throw new CropNotFoundException("Crop with code " + cropCode + " not found");
        } else {
            cropDao.deleteById(cropCode); // Delete crop if found
        }
    }


    @Override
    public void updateCrop(String cropCode, CropDto cropDto) {
        Optional<Crop> tempCrop = cropDao.findById(cropCode);
        if (tempCrop.isPresent()) {
            // Update the crop fields from DTO
            tempCrop.get().setCropName(cropDto.getCropName());
            tempCrop.get().setScientificName(cropDto.getScientificName());
            tempCrop.get().setCropImage(cropDto.getCropImage());  // Use the new crop image

            tempCrop.get().setCategory(cropDto.getCategory());
            tempCrop.get().setSeason(cropDto.getSeason());

            cropDao.save(tempCrop.get());  // Don't forget to save the updated crop entity
        }
    }


//    @Override
//    public String generateCropCode() {
//        String lastCode = cropDao.findLastCropCode();
//        if (lastCode == null){
//            return "Crop-001";
//        }
//        String[] parts = lastCode.split("-");
//        int lastNumber = Integer.parseInt(parts[1]);
//        int newNumber = lastNumber + 1;
//
//        return String.format("Crop-%03d", newNumber);
//    }
}
