package com.hpe.ssa.pojo;

public class Sizes {
    private Integer sizeid;
    private Float sizenum;
    private String sremarks;

    public Sizes() {
    }

    public Sizes(Integer sizeid, Float sizenum, String sremarks) {
        this.sizeid = sizeid;
        this.sizenum = sizenum;
        this.sremarks = sremarks;
    }

    public Integer getSizeid() {
        return sizeid;
    }

    public void setSizeid(Integer sizeid) {
        this.sizeid = sizeid;
    }

    public Float getSizenum() {
        return sizenum;
    }

    public void setSizenum(Float sizenum) {
        this.sizenum = sizenum;
    }

    public String getSremarks() {
        return sremarks;
    }

    public void setSremarks(String sremarks) {
        this.sremarks = sremarks;
    }

    @Override
    public String toString() {
        return "Sizes{" +
                "sizeid=" + sizeid +
                ", sizenum=" + sizenum +
                ", sremarks='" + sremarks + '\'' +
                '}';
    }
}
