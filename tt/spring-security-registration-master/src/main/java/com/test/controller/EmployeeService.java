package com.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	private List<Employee> list = null;

	EmployeeService() {
		Employee emp = new Employee("1", "Hk", 28);
		Employee emp2 = null;
		try {
			emp2 = emp.clone();
			emp2.setAge(45);
			emp2.setId("2");
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (list == null) {

			list = new ArrayList<Employee>();
			list.add(emp);
			list.add(emp2);
		}

	}

	public List<Employee> getListOfEmployees() {

		return list;
	}

	public List<Employee> getList() {
		return list;
	}

	public void setList(List<Employee> list) {
		this.list = list;
	}

	public Employee saveEmployee(String id, String name, Integer age) {
		Employee emp = new Employee(id, name, age);
		list.add(emp);
		return emp;

	}

}
