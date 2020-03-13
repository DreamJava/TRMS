package com.moflexy.dao;

import java.util.List;

import com.moflexy.domain.Form;
import com.moflexy.exception.FormInsertionException;

public interface FormDAO {
	
	public List<Form> retrieveAllForms();
	
	public void insertForm(Form form) throws FormInsertionException;

}
