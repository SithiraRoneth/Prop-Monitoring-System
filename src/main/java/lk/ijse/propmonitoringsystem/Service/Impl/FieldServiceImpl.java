/* Created By Sithira Roneth
 * Date :10/29/24
 * Time :10:33
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoringsystem.Service.Impl;

import lk.ijse.propmonitoringsystem.Service.FieldService;
import lk.ijse.propmonitoringsystem.customStatusCode.SelectedErrorStatus;
import lk.ijse.propmonitoringsystem.dao.FieldDao;
import lk.ijse.propmonitoringsystem.dto.FieldStatus;
import lk.ijse.propmonitoringsystem.dto.impl.FieldDto;
import lk.ijse.propmonitoringsystem.entity.impl.Field;
import lk.ijse.propmonitoringsystem.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FieldServiceImpl implements FieldService {
    @Autowired
    private FieldDao fieldDao;
    @Autowired
    private Mapping mapping;

    @Override
    public void saveField(FieldDto fieldDto) {
        Field savedField = fieldDao.save(mapping.toFieldEntity(fieldDto));
        if (savedField == null) {
            throw new RuntimeException("Save field failed");
        }
    }

    @Override
    public List<FieldDto> getAllFields() {
        List<Field> allField = fieldDao.findAll();
        return mapping.fieldDtoList(allField);
    }

    @Override
    public FieldStatus getSelectedField(String fieldCode) {
        if (fieldDao.existsById(fieldCode)) {
            Field selectedField = fieldDao.getReferenceById(fieldCode);
            return mapping.toFieldDto(selectedField);
        }else {
            return new SelectedErrorStatus(2,"Field with code "+ fieldCode +" not found");
        }
    }

    @Override
    public void updateField(String fieldCode, FieldDto fieldDto) {
        Optional<Field> tempField = fieldDao.findById(fieldCode);
        if (tempField.isPresent()) {
            Field field = tempField.get();
            field.setFieldName(fieldDto.getFieldName());
            field.setFieldLocation(String.valueOf(fieldDto.getFieldLocation()));
            field.setExtendSizeOfTheField(fieldDto.getExtendSizeOfTheField());
            field.setFieldImage1(fieldDto.getFieldImage1());
            field.setFieldImage2(fieldDto.getFieldImage2());
        }
    }

    @Override
    public void deleteField(String fieldCode) {
        Optional<Field> existField = fieldDao.findById(fieldCode);
        if (existField.isPresent()) {
            throw new RuntimeException("Delete field failed");
        }else {
            fieldDao.deleteById(fieldCode);
        }
    }
}
