package com.hpe.ssa.pojo;

public class Permission {
    private Integer perid;
    private String pername;
    private String percont;
    private String peremarks;

    public Permission() {

    }

    public Permission(Integer perid, String pername, String percont, String peremarks) {
        this.perid = perid;
        this.pername = pername;
        this.percont = percont;
        this.peremarks = peremarks;
    }

    public Integer getPerid() {
        return perid;
    }

    public void setPerid(Integer perid) {
        this.perid = perid;
    }

    public String getPername() {
        return pername;
    }

    public void setPername(String pername) {
        this.pername = pername;
    }

    public String getPercont() {
        return percont;
    }

    public void setPercont(String percont) {
        this.percont = percont;
    }

    public String getPeremarks() {
        return peremarks;
    }

    public void setPeremarks(String peremarks) {
        this.peremarks = peremarks;
    }
}
