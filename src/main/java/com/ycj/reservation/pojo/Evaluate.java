package com.ycj.reservation.pojo;

import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.List;

/*
* @Description 点评
* */
@Component
public class Evaluate {
    /*
    *  @Description 商品全局唯一标识ID
    * */
    private String evaluateID;

    /*
    * @Description 对应商品的ID
    *
    * */
    private String goodsID;
    /*
    *  @Description 评分
    * */
    private float scope;

    private String Content;

    /*
    *  @Description 作者
    * */
    private String userID;

    /*
    *  @Description 时间戳
    * */
    private String timeStamp;

}
