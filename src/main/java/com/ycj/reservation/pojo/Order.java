package com.ycj.reservation.pojo;

import org.springframework.stereotype.Component;

import java.util.Date;

/*
*  @Description 账单信息
* */
@Component
public class Order {
    /*
    *  @Description 订单号
    * */
    private String orderID;

    private String userID;

    private String timeStamp;

}
