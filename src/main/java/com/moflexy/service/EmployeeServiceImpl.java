package com.moflexy.service;

import java.util.List;

import com.moflexy.dao.EmployeeDAO;
import com.moflexy.dao.EmployeeDAOPostgres;
import com.moflexy.domain.Employee;
import com.moflexy.exception.EmployeeInsertionException;

public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO employeeDao = new EmployeeDAOPostgres();

	public List<Employee> getAllEmployees() {
		return employeeDao.retrieveAllEmployees();
	}

	public void addEmployee(Employee employee) throws EmployeeInsertionException {
		employeeDao.insertEmployee(employee);
	}
	
	public void setEmployeeDao(EmployeeDAO employeeDao) {
		this.employeeDao = employeeDao;
	}

}
