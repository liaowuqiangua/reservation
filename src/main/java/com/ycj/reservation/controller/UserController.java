package com.ycj.reservation.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ycj.reservation.pojo.Image;
import com.ycj.reservation.service.ImageService;
import com.ycj.reservation.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.List;

/*
*  @Description 用于用户相关操作的controller
* */
@Controller
public class UserController {
    private static final Logger log = LogManager.getLogger(HomeController.class);

    @Autowired
    private UserService userService;

    /*
    * @Param result 返回登录结果
    * */
    @RequestMapping("/login.json")
    @ResponseBody
    public String loginResp(String result){
        return "{\"result\":\""+result+"\"}";
    }

    /*
    * @Description 获取用户登录状态
    * */
    @RequestMapping("/user.json")
    @ResponseBody
    public String init(@AuthenticationPrincipal Principal principal) throws JsonProcessingException {
        if(principal == null){
            return "{\"username\":\"null\"}";
        }
        return userService.getUserLoginInfo(principal.getName());
    }
}
