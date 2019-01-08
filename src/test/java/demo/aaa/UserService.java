package demo.aaa;

import com.ycj.reservation.mapper.UserMapper;
import com.ycj.reservation.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public User newInstance(String username){
        return userMapper.selectByUserName(username);
    }
}
