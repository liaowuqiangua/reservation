package com.ycj.reservation.pojo;

import org.springframework.stereotype.Component;

import java.util.Objects;

/*
* @Description 用户地址以及 用户 店铺地址信息
* */
@Component
public class Address {
    /*
    *  @Description 对应店铺以及用户的地址
    * */
    private String usserID;
    private String city;
    private String street;
    private String detail;
    /*
    *  @Description 经度
    * */
    private Float lat;
    /*
    *  @Description 纬度
    * */
    private Float lng;

}
