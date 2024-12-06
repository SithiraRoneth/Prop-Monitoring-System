/* Created By Sithira Roneth
 * Date :12/6/24
 * Time :09:50
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoringsystem.secure;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class SignIn {
    private String email;
    private String password;
    private String role;
}
