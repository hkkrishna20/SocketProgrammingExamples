package com.test.controller;

public class Employee implements Cloneable {

	public Employee(String id, String name, Integer age) {

		this.id = id;
		this.age = age;
		this.name = name;

	}

	@Override
	public Employee clone() throws CloneNotSupportedException {
		return (Employee) super.clone();
	}


	private String id;
	private String name;

	public void setId(String id) {
		this.id = id;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	private Integer age;

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

}
