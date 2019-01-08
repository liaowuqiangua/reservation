package com.ycj.reservation.pojo;

import org.springframework.stereotype.Component;

/*
 *  @Description 用户对象 用于存放用户基本信息
 */
@Component
public class User {
    private String userID;

    private String username;

    private String password;

    private String email;

    private String phoneNumber;

    /*
    *  @Description 备注信息
    * */
    private String remark;

    /*
    *  @Description 用户权限信息
    *  ROLE_USER,ROLE_ADMIN
    * */
    private String roles;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID='" + userID + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", remark='" + remark + '\'' +
                ", roles='" + roles + '\'' +
                '}';
    }
}
