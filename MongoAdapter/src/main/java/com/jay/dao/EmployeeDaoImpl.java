package com.jay.dao;

import org.springframework.stereotype.Repository;

import com.jay.collection.Employee;

@Repository
public class EmployeeDaoImpl extends MongoDao<Employee> implements EmployeeDao {

	public void insertEmployee(Employee employee) {
		insert(employee);
	}

}
