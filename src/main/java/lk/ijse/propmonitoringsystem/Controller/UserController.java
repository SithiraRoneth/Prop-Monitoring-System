/* Created By Sithira Roneth
 * Date :10/29/24
 * Time :10:26
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoringsystem.Controller;

import lk.ijse.propmonitoringsystem.Service.UserService;
import lk.ijse.propmonitoringsystem.dao.UserDao;
import lk.ijse.propmonitoringsystem.dto.UserStatus;
import lk.ijse.propmonitoringsystem.dto.impl.UserDto;
import lk.ijse.propmonitoringsystem.entity.Role;
import lk.ijse.propmonitoringsystem.entity.impl.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserDao userDao;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveUser(@RequestBody UserDto userDto) {
        try {
            var builduserDto = new UserDto();
            builduserDto.setEmail(userDto.getEmail());
            builduserDto.setPassword(userDto.getPassword());
            builduserDto.setRole(Role.valueOf(String.valueOf(userDto.getRole())));
            System.out.println(builduserDto);
            userService.userSave(builduserDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(value = "{email}/password", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getPassword(@PathVariable("email") String email) {
        try {
            System.out.println("ava");
            if (userDao.existsById(email)) {
                User user = userDao.getReferenceById(email);  // Get the staff record
                String pw = user.getPassword();  // Get the role of the staff as a string
                return ResponseEntity.ok(pw);  // Return the role as the response body
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(("Staff with email " + email + " not found"));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(("Error fetching staff role."));
        }
    }
    @GetMapping(value = "{email}/role", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Role> getUserRole(@PathVariable("email") String email) {
        try {
            if (userDao.existsById(email)) {
                User user = userDao.getReferenceById(email);  // Get the staff record
                Role role = Role.valueOf(String.valueOf(user.getRole()));  // Get the role of the staff as a string
                return ResponseEntity.ok(role);  // Return the role as the response body
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body((Role.valueOf("Staff with email " + email + " not found")));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body((Role.valueOf("Error fetching staff role.")));
        }
    }
//    @GetMapping(value = "/login",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<String> isLoggedIn(@RequestParam String email, @RequestParam String password) {
//        try {
//            boolean isAuthenticated = userService.validateUser(email, password);
//
//            if (isAuthenticated) {
//                return ResponseEntity.ok("Login successful");
//            } else {
//                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error during login");
//        }
//    }

    @GetMapping(value = "{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserStatus getSelectedEmail(@PathVariable("email") String email) {
        return userService.getSelectedUser(email);
    }
    @PutMapping(value = "/{email}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateUser(@PathVariable("email") String email, @RequestBody UserDto userDto) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }

        if (userDto.getPassword() == null || userDto.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }

        // Pass only the email and updated password to the service
        userService.updateUser(email,userDto.getPassword());
    }

}
