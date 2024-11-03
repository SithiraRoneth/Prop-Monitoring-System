package lk.ijse.propmonitoringsystem.Service;

import lk.ijse.propmonitoringsystem.dto.FieldStatus;
import lk.ijse.propmonitoringsystem.dto.impl.FieldDto;

import java.util.List;

public interface FieldService {
    void saveField(FieldDto fieldDto);
    List<FieldDto> getAllFields();
    FieldStatus getSelectedField(String fieldCode);
    void updateField(String fieldCode, FieldDto fieldDto);
    void deleteField(String fieldCode);
}
