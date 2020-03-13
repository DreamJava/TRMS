package com.moflexy.service;

import java.util.List;

import com.moflexy.domain.Form;
import com.moflexy.exception.FormInsertionException;

public interface FormService {
	
	public List<Form> getAllForms();
	
	public void addForm(Form form) throws FormInsertionException;

	public Form getForm();

}
