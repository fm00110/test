package com.ncu.bean;

public class Student {

	private Integer id;
	private int stuid;
	private  String sname;
	private String sex;
	private String phone;
	private String stuusername;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getStuid() {
		return stuid;
	}
	public void setStuid(int stuid) {
		this.stuid = stuid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getStuusername() {
		return stuusername;
	}
	public void setStuusername(String stuusername) {
		this.stuusername = stuusername;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", stuid=" + stuid + ", sname=" + sname + ", sex=" + sex + ", phone=" + phone
				+ ", stuusername=" + stuusername + "]";
	}
	public Student(int stuid, String sname, String sex, String phone, String stuusername) {
		super();
		this.stuid = stuid;
		this.sname = sname;
		this.sex = sex;
		this.phone = phone;
		this.stuusername = stuusername;
	}
	
	
	
}
