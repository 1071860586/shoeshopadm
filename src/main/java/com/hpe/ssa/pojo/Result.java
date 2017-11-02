package com.hpe.ssa.pojo;

public class Result {
    private String bname;
    private int otatol;
    private  int totalMoney;

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public int getOtatol() {
        return otatol;
    }

    public void setOtatol(int otatol) {
        this.otatol = otatol;
    }


    public Result() {
    }

    public Result(String bname, int otatol, int totalMoney) {
        this.bname = bname;
        this.otatol = otatol;
        this.totalMoney = totalMoney;
    }

    @Override
    public String toString() {
        return "Result{" +
                "bname='" + bname + '\'' +
                ", otatol=" + otatol +
                ", totalMoney=" + totalMoney +
                '}';
    }
}
