package com.jay.dao.impl;

import org.springframework.stereotype.Repository;

import com.jay.collection.Employee;
import com.jay.dao.EmployeeDao;
import com.jay.dao.GenericMongoDao;

@Repository
public class EmployeeDaoImpl extends GenericMongoDao<Employee> implements EmployeeDao {

	public void insertEmployee(Employee employee) {
		insert(employee);
	}

}
