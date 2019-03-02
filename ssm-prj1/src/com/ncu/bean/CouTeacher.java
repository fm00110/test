package com.ncu.bean;

public class CouTeacher {

	private int cid;
	private String cname;
	private String tcname;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getTcname() {
		return tcname;
	}
	public void setTcname(String tcname) {
		this.tcname = tcname;
	}
	@Override
	public String toString() {
		return "CouTeacher [cid=" + cid + ", cname=" + cname + ", tcname=" + tcname + "]";
	}
	
}
