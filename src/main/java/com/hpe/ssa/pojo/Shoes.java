package com.hpe.ssa.pojo;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

//鞋子实体类
public class Shoes {
    private Integer sid;
    private Integer stid;//类型
    private String tname;//类型名
    private Integer sbid;//品牌
    private String bname;//品牌名
    private String snum;//序列号
    private String sname;//名称
    private Float sprices;//价格
    private Integer sdiscount;//库存量
    private Date spubtime;//发布时间
    private String sproducer;//成产商
    private String sgender;//款式男or女
    private String scolor;//颜色
    private String sinfo;//相关信息
    private Integer stimesold;//卖出次数
    private String simage;//图片地址
    private String sdetail;//详细信息
    private Float sintegral;//鞋子积分
    private Integer sdelete;//状态
    private String sremarks;
    private String sandroidimg;
    private List<Sizes> sizeList;
    private Integer[] sizeChoose;

    public Shoes() {
    }

    public Shoes(Integer sid, Integer stid, String tname, Integer sbid, String bname, String snum, String sname,
                 Float sprices, Integer sdiscount, Date spubtime, String sproducer, String sgender, String scolor,
                 String sinfo, Integer stimesold, String simage, String sdetail, Float sintegral, Integer sdelete,
                 String sremarks, String sandroidimg, List<Sizes> sizeList) {
        this.sid = sid;
        this.stid = stid;
        this.tname = tname;
        this.sbid = sbid;
        this.bname = bname;
        this.snum = snum;
        this.sname = sname;
        this.sprices = sprices;
        this.sdiscount = sdiscount;
        this.spubtime = spubtime;
        this.sproducer = sproducer;
        this.sgender = sgender;
        this.scolor = scolor;
        this.sinfo = sinfo;
        this.stimesold = stimesold;
        this.simage = simage;
        this.sdetail = sdetail;
        this.sintegral = sintegral;
        this.sdelete = sdelete;
        this.sremarks = sremarks;
        this.sandroidimg = sandroidimg;
        this.sizeList = sizeList;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getStid() {
        return stid;
    }

    public void setStid(Integer stid) {
        this.stid = stid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public Integer getSbid() {
        return sbid;
    }

    public void setSbid(Integer sbid) {
        this.sbid = sbid;
    }

    public String getSnum() {
        return snum;
    }

    public void setSnum(String snum) {
        this.snum = snum;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Float getSprices() {
        return sprices;
    }

    public void setSprices(Float sprices) {
        this.sprices = sprices;
    }

    public Integer getSdiscount() {
        return sdiscount;
    }

    public void setSdiscount(Integer sdiscount) {
        this.sdiscount = sdiscount;
    }

    public Date getSpubtime() {
        return spubtime;
    }

    public void setSpubtime(Date spubtime) {
        this.spubtime = spubtime;
    }

    public String getSproducer() {
        return sproducer;
    }

    public void setSproducer(String sproducer) {
        this.sproducer = sproducer;
    }

    public String getSgender() {
        return sgender;
    }

    public void setSgender(String sgender) {
        this.sgender = sgender;
    }

    public String getScolor() {
        return scolor;
    }

    public void setScolor(String scolor) {
        this.scolor = scolor;
    }

    public String getSinfo() {
        return sinfo;
    }

    public void setSinfo(String sinfo) {
        this.sinfo = sinfo;
    }

    public Integer getStimesold() {
        return stimesold;
    }

    public void setStimesold(Integer stimesold) {
        this.stimesold = stimesold;
    }

    public String getSimage() {
        return simage;
    }

    public void setSimage(String simage) {
        this.simage = simage;
    }

    public String getSdetail() {
        return sdetail;
    }

    public void setSdetail(String sdetail) {
        this.sdetail = sdetail;
    }

    public Float getSintegral() {
        return sintegral;
    }

    public void setSintegral(Float sintegral) {
        this.sintegral = sintegral;
    }

    public Integer getSdelete() {
        return sdelete;
    }

    public void setSdelete(Integer sdelete) {
        this.sdelete = sdelete;
    }

    public String getSremarks() {
        return sremarks;
    }

    public void setSremarks(String sremarks) {
        this.sremarks = sremarks;
    }

    public String getSandroidimg() {
        return sandroidimg;
    }

    public void setSandroidimg(String sandroidimg) {
        this.sandroidimg = sandroidimg;
    }

    public List<Sizes> getSizeList() {
        return sizeList;
    }

    public void setSizeList(List<Sizes> sizeList) {
        this.sizeList = sizeList;
    }

    public Integer[] getSizeChoose() {
        return sizeChoose;
    }

    public void setSizeChoose(Integer[] sizeChoose) {
        this.sizeChoose = sizeChoose;
    }

    @Override
    public String toString() {
        return "Shoes{" +
                "sid=" + sid +
                ", stid=" + stid +
                ", tname='" + tname + '\'' +
                ", sbid=" + sbid +
                ", bname='" + bname + '\'' +
                ", snum='" + snum + '\'' +
                ", sname='" + sname + '\'' +
                ", sprices=" + sprices +
                ", sdiscount=" + sdiscount +
                ", spubtime=" + spubtime +
                ", sproducer='" + sproducer + '\'' +
                ", sgender='" + sgender + '\'' +
                ", scolor='" + scolor + '\'' +
                ", sinfo='" + sinfo + '\'' +
                ", stimesold=" + stimesold +
                ", simage='" + simage + '\'' +
                ", sdetail='" + sdetail + '\'' +
                ", sintegral=" + sintegral +
                ", sdelete=" + sdelete +
                ", sremarks='" + sremarks + '\'' +
                ", sandroidimg='" + sandroidimg + '\'' +
                ", sizeList=" + sizeList +
                ", sizeChoose=" + Arrays.toString(sizeChoose) +
                '}';
    }
}
