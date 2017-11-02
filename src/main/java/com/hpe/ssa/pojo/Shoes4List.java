package com.hpe.ssa.pojo;

//用于展示列表的鞋子实体类
public class Shoes4List {
    private Integer sid;
    private String tname;
    private String bname;
    private String sname;
    private Float sprices;
    private String sproducer;
    private String sgender;
    private String scolor;
    private Integer sdelete;

    public Shoes4List() {
    }

    public Shoes4List(Integer sid, String tname, String bname, String sname, Float sprices, String sproducer, String sgender, String scolor, Integer sdelete) {
        this.sid = sid;
        this.tname = tname;
        this.bname = bname;
        this.sname = sname;
        this.sprices = sprices;
        this.sproducer = sproducer;
        this.sgender = sgender;
        this.scolor = scolor;
        this.sdelete = sdelete;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
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

    public Integer getSdelete() {
        return sdelete;
    }

    public void setSdelete(Integer sdelete) {
        this.sdelete = sdelete;
    }

    @Override
    public String toString() {
        return "Shoes4List{" +
                "sid=" + sid +
                ", tname='" + tname + '\'' +
                ", bname='" + bname + '\'' +
                ", sname='" + sname + '\'' +
                ", sprices=" + sprices +
                ", sproducer='" + sproducer + '\'' +
                ", sgender='" + sgender + '\'' +
                ", scolor='" + scolor + '\'' +
                '}';
    }
}
