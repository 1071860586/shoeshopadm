package com.hpe.ssa.pojo;

public class Brands {
    private Integer bid;
    private String bname;
    private String bsex;
    private Integer bstate;
    private String bremarks;

    public Brands() {
    }

    public Brands(Integer bid, String bname, String bsex, Integer bstate, String bremarks) {
        this.bid = bid;
        this.bname = bname;
        this.bsex = bsex;
        this.bstate = bstate;
        this.bremarks = bremarks;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBsex() {
        return bsex;
    }

    public void setBsex(String bsex) {
        this.bsex = bsex;
    }

    public Integer getBstate() {
        return bstate;
    }

    public void setBstate(Integer bstate) {
        this.bstate = bstate;
    }

    public String getBremarks() {
        return bremarks;
    }

    public void setBremarks(String bremarks) {
        this.bremarks = bremarks;
    }

    @Override
    public String toString() {
        return "Brands{" +
                "bid=" + bid +
                ", bname='" + bname + '\'' +
                ", bsex='" + bsex + '\'' +
                ", bstate=" + bstate +
                ", bremarks='" + bremarks + '\'' +
                '}';
    }
}
