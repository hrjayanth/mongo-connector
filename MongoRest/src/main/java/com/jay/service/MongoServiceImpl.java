package com.jay.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jay.collection.Address;
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
		e.setEmpId("123456789");

		e.setAddresses(getAddressList());

		empDao.insert(e);
		return "success";
	}

	private List<Address> getAddressList() {
		List<Address> addressList = new ArrayList<>();

		Address address = new Address();
		address.setHouseNo("996");
		address.setLine1("III Cross, V Stage, II Phase");
		address.setLine2("BEML Layout");
		address.setCity("Bengluru");
		address.setPostalCode("563115");

		addressList.add(address);
		return addressList;
	}
}
