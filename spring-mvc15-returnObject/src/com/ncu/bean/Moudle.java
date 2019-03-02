package com.ncu.bean;

public class Moudle {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Moudle(String name) {
		super();
		this.name = name;
	}

	public Moudle() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Moudle [name=" + name + "]";
	}
	
}
