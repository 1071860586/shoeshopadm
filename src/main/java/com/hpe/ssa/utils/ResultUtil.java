package com.hpe.ssa.utils;

public class ResultUtil {

    private String res;
    private String info;

    public ResultUtil() {
    }

    public ResultUtil(String res, String info) {
        this.res = res;
        this.info = info;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
