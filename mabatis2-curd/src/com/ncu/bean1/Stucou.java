package com.ncu.bean1;

public class Stucou{

	private String name;
	private int age;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	private String cname;
	
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	@Override
	public String toString() {
		return "Stucou [name=" + name + ", age=" + age + ", cname=" + cname + "]";
	}
	
	
	
	
	
}
