package demo.aaa;

import com.ycj.reservation.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class DemoService {
    private User user;
    DemoService(@Autowired User user){
        this.user = user;
    }
    public String printUserInfo(){
//        user.setUserID(UUID.randomUUID().toString());
        return user.toString();
    }
}
