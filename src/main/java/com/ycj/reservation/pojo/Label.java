package com.ycj.reservation.pojo;

import org.springframework.stereotype.Component;

import java.util.Date;

/*
*  @Description 用户以及商品的标签
* */
@Component
public class Label {

    /*
    *  @Description 全局唯一标签ID
    * */
    private String lebelID;

    /*
     *  标签作用范围 1 : 店铺标签 2 ：商品标签 3 ： 用户标签 ; 暂不分表 可根据range分表优化
     * */
    private String range;
    /*
     *@Description 与 range 作用范围对应的 ID  storeID , goodsID , userID ;
     * */
    private String actID;

    private String field;
    /*
    *  @Description 存放标签发布时间
    * */
    private String timeStamp;
    /*
    *  @Description 添加者
    * */
    private String userID;
    /*
    *  @Description 失效时间
    * */
    private Date deadTime;

}
