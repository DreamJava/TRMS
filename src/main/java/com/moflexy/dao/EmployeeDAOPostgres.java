package com.moflexy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.moflexy.domain.Employee;
import com.moflexy.exception.EmployeeInsertionException;
import com.moflexy.util.ConnectionFactory;

public class EmployeeDAOPostgres implements EmployeeDAO {
	
	private Connection conn = ConnectionFactory.getConnection();
	
	private static final String EMPLOYEE_TABLE = "emp";
	private static final String SELECT_ALL_EMPLOYEES = "select * from " + EMPLOYEE_TABLE;
	private static final String INSERT_EMPLOYEE = "insert into " + EMPLOYEE_TABLE + " (username, password, fullname, dept, empType, dirsupervisor) values(?,?,?,?,?,?)";
	private static final String SELECT_USER_BY_USERNAME = "select * from " + EMPLOYEE_TABLE + " where username=?";

	public List<Employee> retrieveAllEmployees() {
		List<Employee> employeeList = new ArrayList<Employee>();
		try {
			PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_EMPLOYEES);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				employeeList.add(
						new Employee(rs.getString("username"), 
						rs.getString("empID"), 
						rs.getString("password"), 
						rs.getString("fullname"),
						rs.getString("dept"),
						rs.getString("empType"),
						rs.getString("dirsupervisor")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeeList;
	}
	
	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public void insertEmployee(Employee employee) throws EmployeeInsertionException {
		try {
			PreparedStatement stmt = conn.prepareStatement(INSERT_EMPLOYEE);
			stmt.setString(1, employee.getUsername());
			//stmt.setString(2, employee.getID()); --> serial data type can't be set
			stmt.setString(3, employee.getPassword());
			stmt.setString(4, employee.getFullName());
			stmt.setString(5, employee.getDept());
			stmt.setString(6, employee.getType().toString());
			stmt.setString(7, employee.getSupervisor());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			EmployeeInsertionException newE = new EmployeeInsertionException();
			newE.initCause(e);
			throw newE;
		}
	}
	
	public Employee getEmployeeByUsername(String username) {
		Employee emp = null;
		try {
			PreparedStatement stmt = conn.prepareStatement(SELECT_USER_BY_USERNAME);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				emp = new Employee();
				emp.setUsername(rs.getString(1));
				emp.setPassword(rs.getString(3));
				emp.setFullName(rs.getString(4));
				emp.setDept(rs.getString(5));
				emp.setType(Employee.EmployeeType.toValueOf(rs.getString(6)));
				emp.setSupervisor(rs.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}
	
}
