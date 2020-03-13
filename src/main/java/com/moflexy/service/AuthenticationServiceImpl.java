package com.moflexy.service;

import com.moflexy.dao.EmployeeDAO;
import com.moflexy.dao.EmployeeDAOPostgres;
import com.moflexy.domain.Employee;

public class AuthenticationServiceImpl implements AuthenticationService{

	private static EmployeeDAOPostgres employeeDao = new EmployeeDAOPostgres();
	
	public Employee validateUser(String username, String password) {
		Employee user = employeeDao.getEmployeeByUsername(username);
		if (user != null && user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}

	
	
}
