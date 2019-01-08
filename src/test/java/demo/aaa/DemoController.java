package demo.aaa;

import com.ycj.reservation.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class DemoController {
    @Autowired
    private UserService userService;
    @RequestMapping("/test{s}")
    @ResponseBody
    public User test(@PathVariable String s){
        User user = userService.newInstance(s);
        System.out.println(user);
        return user;
    }
}
