package com.jay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jay.collection.Employee;
import com.jay.dao.EmployeeDao;

@Service
public class MongoServiceImpl implements MongoService {

	@Autowired
	EmployeeDao empDao;
	
	@Override
	public String insert() {
		Employee e = new Employee();
		e.setDept("Department");
		e.setName("Name");
		e.setId(123456789L);
		
		empDao.insertEmployee(e);
		return "success";
	}
}
