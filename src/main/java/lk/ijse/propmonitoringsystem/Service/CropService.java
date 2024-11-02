package lk.ijse.propmonitoringsystem.Service;

import lk.ijse.propmonitoringsystem.dto.CropStatus;
import lk.ijse.propmonitoringsystem.dto.impl.CropDto;

import java.util.List;

public interface CropService {
    void saveCrop(CropDto cropDto);
    CropStatus getSelectedCrop(String cropCode);
    List<CropDto> getAllCrops();
    void deleteCrop(String cropCode);
    void updateCrop(String cropCode,CropDto cropDto);
}
