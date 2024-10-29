/* Created By Sithira Roneth
 * Date :10/29/24
 * Time :09:03
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoringsystem.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/health")
public class HealthController {
    @GetMapping
    public String health() {
        return "OK";
    }
}
