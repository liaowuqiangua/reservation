package com.ycj.reservation.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ycj.reservation.mapper.UserMapper;
import com.ycj.reservation.pojo.User;
import com.ycj.reservation.utils.DecodePassword;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private static Logger log = LogManager.getLogger(UserService.class);
    private static final String ERROR_STATUS ="{\"status\":\"404\"}";
    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private UserMapper userMapper;

    public User getUserByName(String username){
        return userMapper.selectByUserName(username);
    }

    public int addUser(User user){
        user.setPassword(new DecodePassword().docode(user.getPassword()));
        return userMapper.insertUser(user);
    }

    public int deleteUserByName(String username){
        return userMapper.deleteUser(username);
    }

    public int updateUserPassword(String password){
        return userMapper.updatePassword(password);
    }

    public int updateUserInfo(String email,String phoneNumber){
        return userMapper.updateUserInfo(email,phoneNumber);
    }

    public String getUserLoginInfo(String username)  {
        try {
            return mapper.writeValueAsString(new UserLoginInfo(username,userMapper.getImageByUsername(username)));
        }
        catch (JsonProcessingException e){
            log.error(e.getMessage());
        }
        return ERROR_STATUS;
    }

    class UserLoginInfo{
        private String username;
        private String iconPath;
        UserLoginInfo(String username,String iconPath){
            this.username=username;
            this.iconPath=iconPath;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getImages() {
            return iconPath;
        }

        public void setImages(String iconPath) {
            this.iconPath = iconPath;
        }
    }
}
