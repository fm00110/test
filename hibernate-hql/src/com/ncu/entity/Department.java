package com.ncu.entity;

import java.util.HashSet;
import java.util.Set;

public class Department {

	private String id;
	private String name;
	
	private Set<Employee> empls = new HashSet<>();

	public Set<Employee> getEmpls() {
		return empls;
	}

	public void setEmpls(Set<Employee> empls) {
		this.empls = empls;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	
}
