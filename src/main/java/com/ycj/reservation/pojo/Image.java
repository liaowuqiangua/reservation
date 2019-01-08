package com.ycj.reservation.pojo;

import org.springframework.stereotype.Component;

/*
* @Description 图片
* */
@Component
public class Image {
    /*
    *  图片作用范围 1 : 店铺主图 2 ：评论图片 3 ： 用户头像 ; 暂不分表 可根据range分表优化
    * */
    private int range;
    /*
    *@Description 与 range 作用范围对应的 ID
    * */
    private String actID;

    private String fullPath;

    private String group;

    private String path;


    public Image(int range, String actID, String fullPath, String group, String path) {
        this.range = range;
        this.actID = actID;
        this.fullPath = fullPath;
        this.group = group;
        this.path = path;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public String getActID() {
        return actID;
    }

    public void setActID(String actID) {
        this.actID = actID;
    }

    public String getFullPath() {
        return fullPath;
    }

    public void setFullPath(String fullPath) {
        this.fullPath = fullPath;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}