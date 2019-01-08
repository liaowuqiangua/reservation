package com.ycj.reservation.pojo;

import org.springframework.stereotype.Component;
import java.util.List;

/*
* @Description 店铺信息
* */
@Component
public class Store {
    /*
    *  @Description 全局唯一标识店铺ID
    * */
    private String storeID;

    private String storeName;

    /*
    *  @Description 店铺地址
    * */
    private Address address;
    /*
    *  @Description 店铺描述
    * */
    private String description;

    /*
    *  @Description 店铺标签
    * */
    private Label label;

    /*
    *  @Description 店主
    * */
    private String userID;

    /*
    *  @Description 店铺状态
    * */
    private String state;

}
