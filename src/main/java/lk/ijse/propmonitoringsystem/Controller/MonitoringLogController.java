/* Created By Sithira Roneth
* Date :10/29/24
* Time :10:27
* Project Name :Prop-Monitoring-System 
* */
package lk.ijse.propmonitoringsystem.Controller;

import lk.ijse.propmonitoringsystem.Service.MonitoringLogService;
import lk.ijse.propmonitoringsystem.dto.MonitoringLogStatus;
import lk.ijse.propmonitoringsystem.dto.impl.MonitoringLogDto;
import lk.ijse.propmonitoringsystem.exception.DataPersistException;
import lk.ijse.propmonitoringsystem.exception.MonitoringNotFoundException;
import lk.ijse.propmonitoringsystem.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/monitors")
public class MonitoringLogController {
    @Autowired
    private MonitoringLogService monitoringLogService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveMonitoring(
            @RequestPart("logCode") String logCode,
            @RequestPart("date") Date date,
            @RequestPart("logDetails") String logDetails,
            @RequestPart("observedImage")MultipartFile observerImage
    ){
        String image = "";
        try {
            byte[] byteLog = observerImage.getBytes();
            image = AppUtil.generateProfilePicToBase64(byteLog);

            var buildMonitor = new MonitoringLogDto();
            buildMonitor.setLogCode(logCode);
            buildMonitor.setDate(date);
            buildMonitor.setLogDetails(logDetails);
            buildMonitor.setObservedImage(image);

            monitoringLogService.saveMonitor(buildMonitor);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "{logCode}",produces = MediaType.APPLICATION_JSON_VALUE)
    public MonitoringLogStatus getSelectedMonitor(@PathVariable("logCode") String logCode){
        return monitoringLogService.getSelectedMonitor(logCode);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MonitoringLogDto> getMonitoringLog(){
        return monitoringLogService.getAllMonitor();
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "{logCode}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteMonitor(@PathVariable("logCode") String logCode){
        try {
            monitoringLogService.deleteMonitor(logCode);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (MonitoringNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping(value = "{logCode}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateMonitor(MonitoringLogDto monitoringLogDto,
                              @RequestPart("logCode") String logCode,
                              @RequestPart("date") Date date,
                              @RequestPart("logDetails") String logDetails,
                              @RequestPart("observedImage")MultipartFile observerImage
    ){
        String imageM = "";
        try {
            byte[] byteImage = observerImage.getBytes();
            imageM = AppUtil.generateProfilePicToBase64(byteImage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        var buildMonitor = new MonitoringLogDto();
        buildMonitor.setLogCode(logCode);
        buildMonitor.setDate(date);
        buildMonitor.setLogDetails(logDetails);
        buildMonitor.setObservedImage(imageM);

        monitoringLogService.updateMonitor(logCode,buildMonitor);
    }
}
