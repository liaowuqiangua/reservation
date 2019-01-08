package com.ycj.reservation.pojo;

import org.springframework.stereotype.Component;

import java.util.List;

/*
* @Description 商品信息（菜 or 其他） 暂不分表 可根据range分表优化
* */
@Component
public class Goods {
    /*
    *  @Description 商品全局唯一标识ID
    * */
    private String goodsID;
    /*
     *  商品作用范围 1 : 店铺固有商品 2 ：用户购物车商品 3 ： 用户订单商品
     * */
    private String range;
    /*
     *@Description 与 range 作用范围对应的 ID storeID,userID,orderID.
     * */
    private String actID;
    /*
    * @Description 通过商品关联店铺信息
    * */
    private Store store;

    private String goodsName;

    private List<Image> images;

    /*
    * @Description 逗号分隔
    * */
    private String label;

    private long price;

    /*
    *  @Description 商品数量 与range 值对应
    * */
    private int volume;

    /*
    *  @Description 销量
    * */
    private int sales;

    /*
    *  @Description 折扣信息 默认为1
    * */
    private float discont = 1f;

    public String getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(String goodsID) {
        this.goodsID = goodsID;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getActID() {
        return actID;
    }

    public void setActID(String actID) {
        this.actID = actID;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public float getDiscont() {
        return discont;
    }

    public void setDiscont(float discont) {
        this.discont = discont;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
