/* Created By Sithira Roneth
 * Date :11/21/24
 * Time :12:26
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoringsystem.Controller;

import lk.ijse.propmonitoringsystem.Service.Impl.EquipmentManageServiceImpl;
import lk.ijse.propmonitoringsystem.dto.impl.EquipmentManageDto;
import lk.ijse.propmonitoringsystem.exception.DataPersistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/eqManage")
public class EquipmentManageController {
    @Autowired
    private EquipmentManageServiceImpl equipmentManageService;

    public ResponseEntity<Void> saveStaffEquipmentDetails(
            @RequestPart("staffEquipId") String staffEquipId,
            @RequestPart("StaffId") String staffId,
            @RequestPart("EquipmentId") String equipmentId
    ) {
        try {
            EquipmentManageDto staffEquipmentDto = new EquipmentManageDto();
            staffEquipmentDto.setStaffEqId(staffEquipId);
            staffEquipmentDto.setStaffId(staffId);
            staffEquipmentDto.setEqCode(equipmentId);
            equipmentManageService.saveEquipmentManage(staffEquipmentDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EquipmentManageDto> getStaffEquipmentDetails() {
        return equipmentManageService.getAllEquipmentManage();
    }
}
