/* Created By Sithira Roneth
 * Date :11/2/24
 * Time :10:15
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoringsystem.util;

import java.util.Base64;
import java.util.UUID;

public class AppUtil {
    public static String generateProfilePicToBase64(byte[] profilePic) {
        return Base64.getEncoder().encodeToString(profilePic);
    }
}
