package com.kikyc.utils.reptile.entity;

import java.util.Date;

public class Res {
    //物品种类
    private String resType;
    //详细描述
    private String resDetails;
    //酬谢方式
    private String reward;
    //丢失地点
    private String resLocation;
    //丢失时间
    private Date resTime;
    //所在链接
    private String resUrl;

    @Override
    public String toString() {
        return "Res{" +
                "resType='" + resType + '\'' +
                ", resDetails='" + resDetails + '\'' +
                ", reward='" + reward + '\'' +
                ", resLocation='" + resLocation + '\'' +
                ", resTime=" + resTime +
                ", resUrl='" + resUrl + '\'' +
                '}';
    }

    public Res(String resType, String resDetails, String reward, String resLocation, Date resTime, String resUrl) {
        this.resType = resType;
        this.resDetails = resDetails;
        this.reward = reward;
        this.resLocation = resLocation;
        this.resTime = resTime;
        this.resUrl = resUrl;
    }

    public Res() {
    }

    public void setResType(String resType) {
        this.resType = resType;
    }

    public void setResDetails(String resDetails) {
        this.resDetails = resDetails;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public void setResLocation(String resLocation) {
        this.resLocation = resLocation;
    }

    public void setResTime(Date resTime) {
        this.resTime = resTime;
    }

    public void setResUrl(String resUrl) {
        this.resUrl = resUrl;
    }

    public String getResType() {
        return resType;
    }

    public String getResDetails() {
        return resDetails;
    }

    public String getReward() {
        return reward;
    }

    public String getResLocation() {
        return resLocation;
    }

    public Date getResTime() {
        return resTime;
    }

    public String getResUrl() {
        return resUrl;
    }



}
