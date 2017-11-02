package com.hpe.ssa.pojo;

import java.util.Date;

public class Orders {
    int id;
    int ouid;
    int orecid;
    String uaccount;
    String adress;
    String ordertime;
    String onum;
    int ostate;
    double ototal;
    String onote;
    float ointegral;
    String oexpinfo;
    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", ouid=" + ouid +
                ", orecid=" + orecid +
                ", oaccount='" + uaccount + '\'' +
                ", adress='" + adress + '\'' +
                ", ordertime=" + ordertime +
                ", onum='" + onum + '\'' +
                ", ostate=" + ostate +
                ", ototal=" + ototal +
                ", onote='" + onote + '\'' +
                ", ointegral=" + ointegral +
                ", oexpinfo='" + oexpinfo + '\'' +
                '}';
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOuid() {
        return ouid;
    }

    public void setOuid(int ouid) {
        this.ouid = ouid;
    }

    public int getOrecid() {
        return orecid;
    }

    public void setOrecid(int orecid) {
        this.orecid = orecid;
    }

    public String getUaccount() {
        return uaccount;
    }

    public void setUaccount(String uaccount) {
        this.uaccount = uaccount;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public String getOnum() {
        return onum;
    }

    public void setOnum(String onum) {
        this.onum = onum;
    }

    public int getOstate() {
        return ostate;
    }

    public void setOstate(int ostate) {
        this.ostate = ostate;
    }

    public double getOtotal() {
        return ototal;
    }

    public void setOtotal(double ototal) {
        this.ototal = ototal;
    }

    public String getOnote() {
        return onote;
    }

    public void setOnote(String onote) {
        this.onote = onote;
    }

    public float getOintegral() {
        return ointegral;
    }

    public void setOintegral(float ointegral) {
        this.ointegral = ointegral;
    }

    public String getOexpinfo() {
        return oexpinfo;
    }

    public void setOexpinfo(String oexpinfo) {
        this.oexpinfo = oexpinfo;
    }


    public Orders() {
    }

}

