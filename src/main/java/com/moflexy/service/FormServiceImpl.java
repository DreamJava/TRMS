package com.moflexy.service;

import java.util.List;

import com.moflexy.dao.FormDAO;
import com.moflexy.dao.FormDAOPostgres;
import com.moflexy.domain.Form;
import com.moflexy.exception.FormInsertionException;

public class FormServiceImpl implements FormService {
	
	private FormDAO formDao = new FormDAOPostgres();

	public List<Form> getAllForms() {
		return formDao.retrieveAllForms();
	}

	public void addForm(Form form) throws FormInsertionException {
		formDao.insertForm(form);
	}
	
	public void setFormDao(FormDAO formDao) {
		this.formDao = formDao;
	}

	public Form getForm() {
		// TODO Auto-generated method stub
		return null;
	}

}
