package com.hpe.ssa.pojo;

import java.util.Date;
//用户实体类

public class Users {
	private int uid;
	private String uaccount;
	private String uname;
	private String utel;
	private String ugender;
	private String upwd;
	private String uemail;
	private Date uregtime;
	private float uintegral;
	private int udelete;
	private String uinfo;
	private String uremarks;

	public Users() {
	}

	public Users(int uid, String uaccount, String uname, String utel, String ugender, String upwd, String uemail,
				 Date uregtime, float uintegral, int udelete, String uinfo, String uremarks) {
		this.uid = uid;
		this.uaccount = uaccount;
		this.uname = uname;
		this.utel = utel;
		this.ugender = ugender;
		this.upwd = upwd;
		this.uemail = uemail;
		this.uregtime = uregtime;
		this.uintegral = uintegral;
		this.udelete = udelete;
		this.uinfo = uinfo;
		this.uremarks = uremarks;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUaccount() {
		return uaccount;
	}

	public void setUaccount(String uaccount) {
		this.uaccount = uaccount;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUtel() {
		return utel;
	}

	public void setUtel(String utel) {
		this.utel = utel;
	}

	public String getUgender() {
		return ugender;
	}

	public void setUgender(String ugender) {
		this.ugender = ugender;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public Date getUregtime() {
		return uregtime;
	}

	public void setUregtime(Date uregtime) {
		this.uregtime = uregtime;
	}

	public float getUintegral() {
		return uintegral;
	}

	public void setUintegral(float uintegral) {
		this.uintegral = uintegral;
	}

	public int getUdelete() {
		return udelete;
	}

	public void setUdelete(int udelete) {
		this.udelete = udelete;
	}

	public String getUinfo() {
		return uinfo;
	}

	public void setUinfo(String uinfo) {
		this.uinfo = uinfo;
	}

	public String getUremarks() {
		return uremarks;
	}

	public void setUremarks(String uremarks) {
		this.uremarks = uremarks;
	}

	@Override
	public String toString() {
		return "Users{" +
				"uid=" + uid +
				", uaccount='" + uaccount + '\'' +
				", uname='" + uname + '\'' +
				", utel='" + utel + '\'' +
				", ugender='" + ugender + '\'' +
				", upwd='" + upwd + '\'' +
				", uemail='" + uemail + '\'' +
				", uregtime=" + uregtime +
				", uintegral=" + uintegral +
				", udelete=" + udelete +
				", uinfo='" + uinfo + '\'' +
				", uremarks='" + uremarks + '\'' +
				'}';
	}
}
