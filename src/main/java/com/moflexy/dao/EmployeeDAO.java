package com.moflexy.dao;

import java.util.List;

import com.moflexy.domain.Employee;
import com.moflexy.exception.EmployeeInsertionException;

public interface EmployeeDAO {
	
	public List<Employee> retrieveAllEmployees();
	
	public void insertEmployee(Employee employee) throws EmployeeInsertionException;
}
