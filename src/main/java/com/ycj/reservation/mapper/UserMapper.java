package com.ycj.reservation.mapper;

import com.ycj.reservation.pojo.Image;
import com.ycj.reservation.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {
    @Select("select * from T_USER where USERNAME = #{username}")
    public User selectByUserName(@Param("username") String username);

    @Insert("insert into T_USER(USERID,USERNAME,PASSWORD,EMAIL,PHONENUMBER,REMARK,ROLES) values ({#userID},{#username},{#password},{#email},{#phoneNumber},{#remark},{#roles})")
    public int insertUser(User user);

    @Delete("delete from T_USER where USERNAME = #{username}")
    public int deleteUser(@Param("username") String username);

    @Update("update T_USER set PASSWORD = {#password}")
    public int updatePassword(@Param("password") String password);

    @Update("update T_USER set EMAIL = {#email} ,phoneNumber = {#phoneNumber}")
    public int updateUserInfo(@Param("email") String email,@Param("phoneNumber")String phoneNumber);

    @Select("select iconPath from yi.T_IMAGE where USERNAME = #{username} ")
    public String getImageByUsername(@Param("username") String username);
}
