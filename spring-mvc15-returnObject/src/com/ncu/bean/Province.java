package com.ncu.bean;

public class Province {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Province(String name) {
		super();
		this.name = name;
	}

	public Province() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Province [name=" + name + "]";
	}
	
}
