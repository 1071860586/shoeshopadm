package com.hpe.ssa.pojo;

public class ShoeSizes {
    private Integer ssid;
    private Integer s_sid;
    private Integer s_sizeid;
    private Integer sstate;
    private String ssremarks;
    private Integer scount;

    public ShoeSizes() {
    }

    public ShoeSizes(Integer ssid, Integer s_sid, Integer s_sizeid, Integer sstate, String ssremarks, Integer scount) {
        this.ssid = ssid;
        this.s_sid = s_sid;
        this.s_sizeid = s_sizeid;
        this.sstate = sstate;
        this.ssremarks = ssremarks;
        this.scount = scount;
    }

    public Integer getSsid() {
        return ssid;
    }

    public void setSsid(Integer ssid) {
        this.ssid = ssid;
    }

    public Integer getS_sid() {
        return s_sid;
    }

    public void setS_sid(Integer s_sid) {
        this.s_sid = s_sid;
    }

    public Integer getS_sizeid() {
        return s_sizeid;
    }

    public void setS_sizeid(Integer s_sizeid) {
        this.s_sizeid = s_sizeid;
    }

    public Integer getSstate() {
        return sstate;
    }

    public void setSstate(Integer sstate) {
        this.sstate = sstate;
    }

    public String getSsremarks() {
        return ssremarks;
    }

    public void setSsremarks(String ssremarks) {
        this.ssremarks = ssremarks;
    }

    public Integer getScount() {
        return scount;
    }

    public void setScount(Integer scount) {
        this.scount = scount;
    }

    @Override
    public String toString() {
        return "ShoeSizes{" +
                "ssid=" + ssid +
                ", s_sid=" + s_sid +
                ", s_sizeid=" + s_sizeid +
                ", sstate=" + sstate +
                ", ssremarks='" + ssremarks + '\'' +
                ", scount=" + scount +
                '}';
    }
}
