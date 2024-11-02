/* Created By Sithira Roneth
 * Date :11/2/24
 * Time :13:04
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoringsystem.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/health")
public class HealthChecker {
    @GetMapping
    public String HealthChecker() {
        return "OK";
    }
}
