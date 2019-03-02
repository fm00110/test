package com.ncu.bean;

public class Teacher {

	private Integer id;
	private int tcid;
	private String tcname;
	private String position;
	private String tcusername;
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Teacher(int tcid, String tcname, String position, String tcusername) {
		super();
		this.tcid = tcid;
		this.tcname = tcname;
		this.position = position;
		this.tcusername = tcusername;
	}
	public String getTcusername() {
		return tcusername;
	}
	public void setTcusername(String tcusername) {
		this.tcusername = tcusername;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getTcid() {
		return tcid;
	}
	public void setTcid(int tcid) {
		this.tcid = tcid;
	}
	public String getTcname() {
		return tcname;
	}
	public void setTcname(String tcname) {
		this.tcname = tcname;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	
}
