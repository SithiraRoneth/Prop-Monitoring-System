/* Created By Sithira Roneth
* Date :10/29/24
* Time :10:33
* Project Name :Prop-Monitoring-System 
* */
package lk.ijse.propmonitoringsystem.Service.Impl;

import lk.ijse.propmonitoringsystem.Service.MonitoringLogService;
import lk.ijse.propmonitoringsystem.customStatusCode.SelectedErrorStatus;
import lk.ijse.propmonitoringsystem.dao.MonitoringDao;
import lk.ijse.propmonitoringsystem.dto.MonitoringLogStatus;
import lk.ijse.propmonitoringsystem.dto.impl.MonitoringLogDto;
import lk.ijse.propmonitoringsystem.entity.impl.MonitoringLog;
import lk.ijse.propmonitoringsystem.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonitoringLogServiceImpl implements MonitoringLogService {
    @Autowired
    private MonitoringDao monitoringDao;
    @Autowired
    private Mapping mapping;
    @Override
    public void saveMonitor(MonitoringLogDto monitoringLogDto) {
        MonitoringLog savedMonitor = monitoringDao.save(mapping.toMonitorEntity(monitoringLogDto));
        if (savedMonitor == null){
            throw new RuntimeException("Failed to save monitoring log");
        }
    }

    @Override
    public List<MonitoringLogDto> getAllMonitor() {
        List<MonitoringLog> allMonitor = monitoringDao.findAll();
        return mapping.toMonitorDtoList(allMonitor);
    }

    @Override
    public MonitoringLogStatus getSelectedMonitor(String logCode) {
        if (monitoringDao.existsById(logCode)){
            MonitoringLog referenceById = monitoringDao.getReferenceById(logCode);
            return mapping.toMonitorDto(referenceById);
        }else {
            return new SelectedErrorStatus(2,"Monitoring Log"+ logCode+ " Not Found");
        }
    }

    @Override
    public void updateMonitor(String logCode, MonitoringLogDto monitoringLogDto) {
//        Optional<MonitoringLog> tempMonitor = monitoringDao.findById(logCode);
//        if (tempMonitor.isPresent()){
//            MonitoringLog monitoringLog = tempMonitor.get();
//            monitoringLog.setDate(monitoringLogDto.getDate());
//            monitoringLog.setLogDetails(monitoringLogDto.getLogDetails());
//            monitoringLog.setObservedImage(monitoringLogDto.getObservedImage());
//        }
    }

    @Override
    public void deleteMonitor(String logCode) {
        Optional<MonitoringLog> exist = monitoringDao.findById(logCode);
        if (exist.isPresent()){
            throw new RuntimeException("Monitoring Log Deleted Failed");
        }else {
            monitoringDao.deleteById(logCode);
        }
    }
}
