package com.sh.springbootdemo.bean;


import java.io.Serializable;

public class Xs0101 implements Serializable {
    private String xs0101id;
    private  String xh;
    private String xm;
    private String zymc;
    private String bjmc;

    public Xs0101(String xs0101id, String xh, String xm, String zymc, String bjmc) {
        this.xs0101id = xs0101id;
        this.xh = xh;
        this.xm = xm;
        this.zymc = zymc;
        this.bjmc = bjmc;
    }

    public String getXs0101id() {
        return xs0101id;
    }

    public void setXs0101id(String xs0101id) {
        this.xs0101id = xs0101id;
    }

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getZymc() {
        return zymc;
    }

    public void setZymc(String zymc) {
        this.zymc = zymc;
    }

    public String getBjmc() {
        return bjmc;
    }

    public void setBjmc(String bjmc) {
        this.bjmc = bjmc;
    }

    @Override
    public String toString() {
        return "Xs0101{" +
                "xs0101id='" + xs0101id + '\'' +
                ", xh='" + xh + '\'' +
                ", xm='" + xm + '\'' +
                ", zymc='" + zymc + '\'' +
                ", bjmc='" + bjmc + '\'' +
                '}';
    }

    public Xs0101() {
    }
}
