package com.ycj.reservation.pojo;

import org.springframework.stereotype.Component;

/*
* @Description 用户账户信息
* */
@Component
public class Account {
    private String userID;
    /*
    *  @Description 全局唯一账户ID
    * */
    private String accountID;

    /*
    *  @Description 余额
    * */
    private long remaingSum;

    private String bankCardId;

}
