package com.hpe.ssa.pojo;

public class Types {
    private Integer tid;
    private String tname;
    private String tremarks;
    private Integer tdelete;

    public Types() {
    }

    public Types(Integer tid, String tname, String tremarks, Integer tdelete) {
        this.tid = tid;
        this.tname = tname;
        this.tremarks = tremarks;
        this.tdelete = tdelete;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTremarks() {
        return tremarks;
    }

    public void setTremarks(String tremarks) {
        this.tremarks = tremarks;
    }

    public Integer getTdelete() {
        return tdelete;
    }

    public void setTdelete(Integer tdelete) {
        this.tdelete = tdelete;
    }

    @Override
    public String toString() {
        return "Types{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", tremarks='" + tremarks + '\'' +
                ", tdelete=" + tdelete +
                '}';
    }
}
