package com.hpe.ssa.pojo;

public class SpcifyResults {
    int sprid;
    String spsname;
    String onum;
    String sprscheme;
    double sprsize;
    int sprnum;
    String spremarks;
    int spstate;
    public SpcifyResults() {
    }

    public SpcifyResults(String spsname, String onum, String sprscheme, double sprsize, int sprnum, String spremarks, int spstate) {
        this.spsname = spsname;
        this.onum = onum;
        this.sprscheme = sprscheme;
        this.sprsize = sprsize;
        this.sprnum = sprnum;
        this.spremarks = spremarks;
        this.spstate = spstate;
    }

    @Override
    public String toString() {
        return "SpcifyResults{" +
                "sprid=" + sprid +
                ", spsname='" + spsname + '\'' +
                ", onum='" + onum + '\'' +
                ", sprscheme='" + sprscheme + '\'' +
                ", sprsize=" + sprsize +
                ", sprnum=" + sprnum +
                ", spremarks='" + spremarks + '\'' +
                ", spstate=" + spstate +
                '}';
    }



    public int getSprid() {
        return sprid;
    }

    public void setSprid(int sprid) {
        this.sprid = sprid;
    }

    public String getSpsname() {
        return spsname;
    }

    public void setSpsname(String spsname) {
        this.spsname = spsname;
    }

    public String getOnum() {
        return onum;
    }

    public void setOnum(String onum) {
        this.onum = onum;
    }

    public String getSprscheme() {
        return sprscheme;
    }

    public void setSprscheme(String sprscheme) {
        this.sprscheme = sprscheme;
    }

    public double getSprsize() {
        return sprsize;
    }

    public void setSprsize(double sprsize) {
        this.sprsize = sprsize;
    }

    public int getSprnum() {
        return sprnum;
    }

    public void setSprnum(int sprnum) {
        this.sprnum = sprnum;
    }

    public String getSpremarks() {
        return spremarks;
    }

    public void setSpremarks(String spremarks) {
        this.spremarks = spremarks;
    }

    public int getSpstate() {
        return spstate;
    }

    public void setSpstate(int spstate) {
        this.spstate = spstate;
    }


}
