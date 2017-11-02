package com.hpe.ssa.pojo;
//用于展示列表的管理员实体类
public class AdminsList {
    private Integer aid;
    private String acount;
    private String apwd;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAcount() {
        return acount;
    }

    public void setAcount(String acount) {
        this.acount = acount;
    }

    public String getApwd() {
        return apwd;
    }

    public void setApwd(String apwd) {
        this.apwd = apwd;
    }

    public AdminsList() {
    }

    public AdminsList(Integer aid, String acount, String apwd) {
        this.aid = aid;
        this.acount = acount;
        this.apwd = apwd;
    }

}
