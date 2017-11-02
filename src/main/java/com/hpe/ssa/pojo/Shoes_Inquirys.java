package com.hpe.ssa.pojo;

import java.sql.Date;
/*
liukaiming
 */
public class Shoes_Inquirys {
    private int sqid;
    private int sq_uid;
    private int sq_sid;
    private String sqquestion;
    private String sqanswer;
    private Date sqquestiontime;
    private Date sqanswertime;
    private String sqremarks;
    private String uname;
    private String sname;

    public Shoes_Inquirys() {
    }

    public Shoes_Inquirys(int sqid, int sq_uid, int sq_sid, String sqquestion, String sqanswer, Date sqquestiontime, Date sqanswertime, String sqremarks, String uname, String sname) {
        this.sqid = sqid;
        this.sq_uid = sq_uid;
        this.sq_sid = sq_sid;
        this.sqquestion = sqquestion;
        this.sqanswer = sqanswer;
        this.sqquestiontime = sqquestiontime;
        this.sqanswertime = sqanswertime;
        this.sqremarks = sqremarks;
        this.uname = uname;
        this.sname = sname;
    }

    public int getSqid() {
        return sqid;
    }

    public void setSqid(int sqid) {
        this.sqid = sqid;
    }

    public int getSq_uid() {
        return sq_uid;
    }

    public void setSq_uid(int sq_uid) {
        this.sq_uid = sq_uid;
    }

    public int getSq_sid() {
        return sq_sid;
    }

    public void setSq_sid(int sq_sid) {
        this.sq_sid = sq_sid;
    }

    public String getSqquestion() {
        return sqquestion;
    }

    public void setSqquestion(String sqquestion) {
        this.sqquestion = sqquestion;
    }

    public String getSqanswer() {
        return sqanswer;
    }

    public void setSqanswer(String sqanswer) {
        this.sqanswer = sqanswer;
    }

    public Date getSqquestiontime() {
        return sqquestiontime;
    }

    public void setSqquestiontime(Date sqquestiontime) {
        this.sqquestiontime = sqquestiontime;
    }

    public Date getSqanswertime() {
        return sqanswertime;
    }

    public void setSqanswertime(Date sqanswertime) {
        this.sqanswertime = sqanswertime;
    }

    public String getSqremarks() {
        return sqremarks;
    }

    public void setSqremarks(String sqremarks) {
        this.sqremarks = sqremarks;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
}
