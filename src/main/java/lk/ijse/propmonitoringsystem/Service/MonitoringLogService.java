package lk.ijse.propmonitoringsystem.Service;

import lk.ijse.propmonitoringsystem.dto.MonitoringLogStatus;
import lk.ijse.propmonitoringsystem.dto.impl.MonitoringLogDto;

import java.util.List;

public interface MonitoringLogService {
    void saveMonitor(MonitoringLogDto monitoringLogDto);
    List<MonitoringLogDto> getAllMonitor();
    MonitoringLogStatus getSelectedMonitor(String logCode);
    void updateMonitor(String logCode,MonitoringLogDto monitoringLogDto);
    void deleteMonitor(String logCode);
}
