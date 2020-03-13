package com.moflexy.service;

import com.moflexy.domain.Employee;

public interface AuthenticationService {
	
	public Employee validateUser(String username, String password);

}
