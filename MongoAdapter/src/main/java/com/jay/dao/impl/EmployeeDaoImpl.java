package com.jay.dao.impl;

import org.springframework.stereotype.Repository;

import com.jay.collection.Employee;
import com.jay.dao.EmployeeDao;

@Repository
public class EmployeeDaoImpl extends GenericMongoDaoImpl<Employee> implements EmployeeDao {

}
