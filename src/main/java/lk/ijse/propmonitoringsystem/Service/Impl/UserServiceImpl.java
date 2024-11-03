/* Created By Sithira Roneth
 * Date :10/29/24
 * Time :10:34
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoringsystem.Service.Impl;

import lk.ijse.propmonitoringsystem.Service.UserService;
import lk.ijse.propmonitoringsystem.dao.UserDao;
import lk.ijse.propmonitoringsystem.dto.impl.UserDto;
import lk.ijse.propmonitoringsystem.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private Mapping mapping;

    @Override
    public void userSave(UserDto userDto) {

    }
}
