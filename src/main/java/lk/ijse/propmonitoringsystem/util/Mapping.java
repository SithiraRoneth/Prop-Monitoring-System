///* Created By Sithira Roneth
// * Date :11/2/24
// * Time :10:22
// * Project Name :Prop-Monitoring-System
// * */
//package lk.ijse.propmonitoringsystem.util;
//
//import lk.ijse.propmonitoringsystem.dto.impl.*;
//import lk.ijse.propmonitoringsystem.entity.impl.*;
//import org.modelmapper.ModelMapper;
//import org.modelmapper.TypeToken;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//public class Mapping {
//    @Autowired
//    private ModelMapper modelMapper;
//    // crop
//    public Crop toCropEntity(CropDto cropDto) {
//        return modelMapper.map(cropDto, Crop.class);
//    }
//    public CropDto toCropDto(Crop crop) {
//        return modelMapper.map(crop, CropDto.class);
//    }
//    public List<CropDto> cropDtoList(List<Crop> cropList) {
//        return modelMapper.map(cropList, new TypeToken<List<CropDto>>() {}.getType());
//    }
//    // field
//    public Field toFieldEntity(FieldDto fieldDtoDto) {
//        return modelMapper.map(fieldDtoDto, Field.class);
//    }
//    public FieldDto toFieldDto(Field field) {
//        return modelMapper.map(field, FieldDto.class);
//    }
//    public List<FieldDto> fieldDtoList(List<Field> fieldList) {
//        return modelMapper.map(fieldList, new TypeToken<List<FieldDto>>() {}.getType());
//    }
//    // vehicle
//    public Vehicle toVehicleEntity(VehicleDto vehicleDto) {
//        return modelMapper.map(vehicleDto, Vehicle.class);
//    }
//    public VehicleDto toVehicleDto(Vehicle vehicle) {
//        return modelMapper.map(vehicle, VehicleDto.class);
//    }
//    public List<VehicleDto> vehicleDtoList(List<Vehicle> vehicleList) {
//        return modelMapper.map(vehicleList, new TypeToken<List<VehicleDto>>() {}.getType());
//    }
//    // equipment
//    public Equipment toEquipmentEntity(EquipmentDto equipmentDto) {
//        System.out.println(equipmentDto);
//        return modelMapper.map(equipmentDto, Equipment.class);
//    }
//    public EquipmentDto toEquipmentDto(Equipment equipment) {
//        return modelMapper.map(equipment, EquipmentDto.class);
//    }
//    public List<EquipmentDto> toEquipmentDtoList(List<Equipment> equipmentList) {
//        return modelMapper.map(equipmentList, new TypeToken<List<EquipmentDto>>() {}.getType());
//    }
//    // staff
//    public Staff toStaffEntity(StaffDto staffDto) {
//        return modelMapper.map(staffDto, Staff.class);
//    }
//    public StaffDto toStaffDto(Staff staff) {
//        return modelMapper.map(staff, StaffDto.class);
//    }
//    public List<StaffDto> toStaffDtoList(List<Staff> staffList) {
//        return modelMapper.map(staffList, new TypeToken<List<StaffDto>>() {}.getType());
//    }
//
//    // monitoring
//    public MonitoringLog toMonitorEntity(MonitoringLogDto monitoringLogDto) {
//        return modelMapper.map(monitoringLogDto, MonitoringLog.class);
//    }
//    public MonitoringLogDto toMonitorDto(MonitoringLog monitoringLog) {
//        return modelMapper.map(monitoringLog, MonitoringLogDto.class);
//    }
//    public List<MonitoringLogDto> toMonitorDtoList(List<MonitoringLog> monitoringLogs) {
//        return modelMapper.map(monitoringLogs, new TypeToken<List<MonitoringLogDto>>() {}.getType());
//    }
//    // fieldEquipmentDetails
//    public EquipmentManage toFieldEquipmentDetailsEntity(FieldEquipmentDetailsDto fieldEquipmentDetailsDto) {
//        return modelMapper.map(fieldEquipmentDetailsDto, EquipmentManage.class);
//    }
//    public FieldEquipmentDetailsDto toFieldEquipmentDetailsDto(EquipmentManage fieldEquipmentDetails) {
//        return modelMapper.map(fieldEquipmentDetails, FieldEquipmentDetailsDto.class);
//    }
//    public List<FieldEquipmentDetailsDto> FieldEquipmentDetailsList(List<EquipmentManage> fieldEquipmentDetailsList) {
//        return modelMapper.map(fieldEquipmentDetailsList, new TypeToken<List<FieldEquipmentDetailsDto>>() {}.getType());
//    }
//
////    // staffEquipmentDetails
////    public StaffEquipmentDetails toStaffEquipmentDetailsEntity(StaffEquipmentDto staffEquipmentDto) {
////        return modelMapper.map(staffEquipmentDto, StaffEquipmentDetails.class);
////    }
////    public StaffEquipmentDto toStaffEquipmentDetailsDto(StaffEquipmentDetails staffEquipmentDetails) {
////        return modelMapper.map(staffEquipmentDetails, StaffEquipmentDto.class);
////    }
////    public List<StaffEquipmentDto> StaffEquipmentDetailsList(List<StaffEquipmentDetails> staffEquipmentDetailsList) {
////        return modelMapper.map(staffEquipmentDetailsList, new TypeToken<List<StaffEquipmentDto>>() {}.getType());
////    }
//
//    // staffFieldDetails
//    public DutyManage toStaffFieldDetailsEntity(StaffFieldDetailsDto staffFieldDetailsDto) {
//        return modelMapper.map(staffFieldDetailsDto, DutyManage.class);
//    }
//    public StaffFieldDetailsDto toStaffFieldDetailsDto(DutyManage staffFieldDetails) {
//        return modelMapper.map(staffFieldDetails, StaffFieldDetailsDto.class);
//    }
//    public List<StaffFieldDetailsDto> StaffFieldDetailsList(List<DutyManage> staffFieldDetailsList) {
//        return modelMapper.map(staffFieldDetailsList, new TypeToken<List<StaffFieldDetailsDto>>() {}.getType());
//    }
//
//    // userStaffDetails
//    public UserStaffDetails toUserStaffDetailsEntity(UserStaffDetailsDto userStaffDetailsDto) {
//        return modelMapper.map(userStaffDetailsDto, UserStaffDetails.class);
//    }
//    public UserStaffDetailsDto toUserStaffDetailsDto(UserStaffDetails userStaffDetails) {
//        return modelMapper.map(userStaffDetails, UserStaffDetailsDto.class);
//    }
//    public List<UserStaffDetailsDto> UserStaffDetailsList(List<UserStaffDetails> userStaffDetailsList) {
//        return modelMapper.map(userStaffDetailsList, new TypeToken<List<UserStaffDetailsDto>>() {}.getType());
//    }
//}
/* Created By Sithira Roneth
 * Date : 11/2/24
 * Time : 10:22
 * Project Name : Prop-Monitoring-System
 */
package lk.ijse.propmonitoringsystem.util;

import lk.ijse.propmonitoringsystem.dto.impl.*;
import lk.ijse.propmonitoringsystem.entity.impl.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    // Crop
    public Crop toCropEntity(CropDto cropDto) {
        return modelMapper.map(cropDto, Crop.class);
    }
    public CropDto toCropDto(Crop crop) {
        return modelMapper.map(crop, CropDto.class);
    }
    public List<CropDto> toCropDtoList(List<Crop> cropList) {
        return modelMapper.map(cropList, new TypeToken<List<CropDto>>() {}.getType());
    }

    // Field
    public Field toFieldEntity(FieldDto fieldDto) {
        return modelMapper.map(fieldDto, Field.class);
    }
    public FieldDto toFieldDto(Field field) {
        return modelMapper.map(field, FieldDto.class);
    }
    public List<FieldDto> toFieldDtoList(List<Field> fieldList) {
        return modelMapper.map(fieldList, new TypeToken<List<FieldDto>>() {}.getType());
    }

    // Vehicle
    public Vehicle toVehicleEntity(VehicleDto vehicleDto) {
        return modelMapper.map(vehicleDto, Vehicle.class);
    }
    public VehicleDto toVehicleDto(Vehicle vehicle) {
        return modelMapper.map(vehicle, VehicleDto.class);
    }
    public List<VehicleDto> toVehicleDtoList(List<Vehicle> vehicleList) {
        return modelMapper.map(vehicleList, new TypeToken<List<VehicleDto>>() {}.getType());
    }

    // Equipment
    public Equipment toEquipmentEntity(EquipmentDto equipmentDto) {
        return modelMapper.map(equipmentDto, Equipment.class);
    }
    public EquipmentDto toEquipmentDto(Equipment equipment) {
        return modelMapper.map(equipment, EquipmentDto.class);
    }
    public List<EquipmentDto> toEquipmentDtoList(List<Equipment> equipmentList) {
        return modelMapper.map(equipmentList, new TypeToken<List<EquipmentDto>>() {}.getType());
    }

    // Staff
    public Staff toStaffEntity(StaffDto staffDto) {
        return modelMapper.map(staffDto, Staff.class);
    }
    public StaffDto toStaffDto(Staff staff) {
        return modelMapper.map(staff, StaffDto.class);
    }
    public List<StaffDto> toStaffDtoList(List<Staff> staffList) {
        return modelMapper.map(staffList, new TypeToken<List<StaffDto>>() {}.getType());
    }

    // Monitoring
    public MonitoringLog toMonitorEntity(MonitoringLogDto monitoringLogDto) {
        return modelMapper.map(monitoringLogDto, MonitoringLog.class);
    }
    public MonitoringLogDto toMonitorDto(MonitoringLog monitoringLog) {
        return modelMapper.map(monitoringLog, MonitoringLogDto.class);
    }
    public List<MonitoringLogDto> toMonitorDtoList(List<MonitoringLog> monitoringLogs) {
        return modelMapper.map(monitoringLogs, new TypeToken<List<MonitoringLogDto>>() {}.getType());
    }

    // Field Equipment Details
    public EquipmentManage toFieldEquipmentDetailsEntity(FieldCropDetailsDto fieldEquipmentDetailsDto) {
        return modelMapper.map(fieldEquipmentDetailsDto, EquipmentManage.class);
    }
    public FieldCropDetailsDto toFieldEquipmentDetailsDto(EquipmentManage fieldEquipmentDetails) {
        return modelMapper.map(fieldEquipmentDetails, FieldCropDetailsDto.class);
    }
    public List<FieldCropDetailsDto> toFieldEquipmentDetailsDtoList(List<EquipmentManage> fieldEquipmentDetailsList) {
        return modelMapper.map(fieldEquipmentDetailsList, new TypeToken<List<FieldCropDetailsDto>>() {}.getType());
    }

    // Staff Field Details
    public EquipmentManage toEquipmentManageEntity(EquipmentManageDto equipmentManageDto) {
        return modelMapper.map(equipmentManageDto, EquipmentManage.class);
    }
    public EquipmentManageDto toEquipmentManageDto(EquipmentManage equipmentManage) {
        return modelMapper.map(equipmentManage, EquipmentManageDto.class);
    }
    public List<EquipmentManageDto> toEquipmentManageDtoList(List<EquipmentManage> equipmentManageList) {
        return modelMapper.map(equipmentManageList, new TypeToken<List<EquipmentManageDto>>() {}.getType());
    }

    //Duty Manage
    public DutyManage toDutyManageEntity(DutyManageDto dutyManageDto) {
        return modelMapper.map(dutyManageDto, DutyManage.class);
    }
    public DutyManageDto toDutyManageDto(DutyManage dutyManage) {
        return modelMapper.map(dutyManage, DutyManageDto.class);
    }
    public List<DutyManageDto> toDutyManageDtoList(List<DutyManage> dutyManageList) {
        return modelMapper.map(dutyManageList, new TypeToken<List<DutyManageDto>>() {}.getType());
    }

    // User Staff Details
    public UserStaffDetails toUserStaffDetailsEntity(UserStaffDetailsDto userStaffDetailsDto) {
        return modelMapper.map(userStaffDetailsDto, UserStaffDetails.class);
    }
    public UserStaffDetailsDto toUserStaffDetailsDto(UserStaffDetails userStaffDetails) {
        return modelMapper.map(userStaffDetails, UserStaffDetailsDto.class);
    }
    public List<UserStaffDetailsDto> toUserStaffDetailsDtoList(List<UserStaffDetails> userStaffDetailsList) {
        return modelMapper.map(userStaffDetailsList, new TypeToken<List<UserStaffDetailsDto>>() {}.getType());
    }

    public User toUserEntity(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }
    public UserDto toUserDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }
    public List<UserDto> touserDtoList(List<User> users) {
        return modelMapper.map(users, new TypeToken<List<UserDto>>() {}.getType());
    }
}

