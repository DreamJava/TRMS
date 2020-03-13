package com.moflexy.service;

import java.util.List;

import com.moflexy.domain.Employee;
import com.moflexy.exception.EmployeeInsertionException;

public interface EmployeeService {
	
	public List<Employee> getAllEmployees();
	
	public void addEmployee(Employee employee) throws EmployeeInsertionException;

}
