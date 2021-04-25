package com.jay.collection;

import com.jay.annotations.Collection;

@Collection(name = "Employee", database = "Organization")
public class Employee {
	private String name;
	private Long id;
	private String dept;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

}
