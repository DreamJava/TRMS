package com.moflexy.domain;

public class Employee {

	/**
		 * @author nealr
		 *
		 */
	public enum EmployeeType {
		SUPERVISOR, DEPT_HEAD, BENCO, STANDARD;

		public static EmployeeType toValueOf(String string) {
			int type = Integer.parseInt(string);
			EmployeeType eType = null;
			switch(type) {
			case 0:
				return EmployeeType.STANDARD;
			case 1:
				return EmployeeType.SUPERVISOR;
			case 2:
				return EmployeeType.DEPT_HEAD;
			case 3:
				return EmployeeType.BENCO;
			}
			return null;
		}
	}

	protected String username;
	protected String password;
	protected String empID;
	protected String fullName;
	protected String dept;
	private EmployeeType empType;
	protected String dirSupervisor;
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	public String getID() {
		return empID;
	}
	
	public void setID(String empID) {
		this.empID = empID;
	}
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDept() {
		return dept;
	}
	
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public EmployeeType getType() {
		return empType;
	}
	
	public void setType(EmployeeType empType) {
		this.empType = empType;
	}
	
	public String getSupervisor() {
		return dirSupervisor;
	}
	
	public void setSupervisor(String dirSupervisor) {
		this.dirSupervisor = dirSupervisor;
	}
	
	public Employee() {
		
	}

	public Employee(String uname, String empID, String pass, String fullName, String dept, String empType,
			String dirSupervisor) {
		// TODO Auto-generated constructor stub
	}

//	public static EmployeeType toType(EmployeeType type) {
//		switch(type) {
//			case SUPERVISOR:
//				return EmployeeType.SUPERVISOR;
//			case DEPT_HEAD:
//				return EmployeeType.DEPT_HEAD;
//			case BENCO:
//				return EmployeeType.BENCO;
//			case STANDARD:
//				return EmployeeType.STANDARD;
//		}
//		return null;
//	}

}
