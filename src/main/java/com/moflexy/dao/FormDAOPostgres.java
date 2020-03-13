package com.moflexy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.moflexy.domain.Form;
import com.moflexy.exception.FormInsertionException;
import com.moflexy.util.ConnectionFactory;

public class FormDAOPostgres implements FormDAO {
	
	private static Connection conn = ConnectionFactory.getConnection();
	
	private static final String FORM_TABLE = "form";
	private static final String FORM_TABLE_GSON = "formgson";
	private static final String SELECT_ALL_FORMS = "select * from " + FORM_TABLE;
	private static final String INSERT_FORM = "insert into " + FORM_TABLE + " (employeeID, date, time, location, description, costs, gradingformat, type, justification, urgency) values(?,?,?,?,?,?,?,?,?,?)";
	private static final String INSERT_FORM_GSON = "insert into " + FORM_TABLE_GSON + " (employeeID, date, time, location, description, costs, gradingformat, type, justification, urgency) values(?,?,?,?,?,?,?,?,?,?)";
	private static final String LAST_ID = "select formID from " + FORM_TABLE + "order by formID desc limit 1";
	Gson gson = new Gson();


	public static int getNewID(){
		int id = 1;
		try {
			PreparedStatement stmt = conn.prepareStatement(LAST_ID);
			ResultSet rs = stmt.executeQuery();
			id = rs.getInt("formID") + 1;
			id = id;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	public List<Form> retrieveAllForms() {
		List<Form> formList = new ArrayList<Form>();
		try {
			PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_FORMS);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Form form = gson.fromJson(rs.getString("formObject"), Form.class);
//				form.setEmpID(Integer.parseInt((rs.getString("employeeID"))));
//				form.setDate(rs.getDate("date"));
//				form.setTime(rs.getString("time"));
//				form.setLocation(rs.getString("location"));
//				form.setDescription(rs.getString("description"));
//				form.setCosts(rs.getString("costs"));
//				form.setGradingFormat(rs.getString("gradingformat"));
//				form.setType(rs.getString("type"));
//				form.setJustification(rs.getString("justification"));
//				form.setUrgency(Integer.parseInt(rs.getString("urgency")));
				formList.add(form);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return formList;
	}
	
	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public void insertForm(Form form) throws FormInsertionException {
		try {
			PreparedStatement stmt = conn.prepareStatement(INSERT_FORM);
			//stmt.setInt(1, form.getFormID());
			stmt.setInt(1, form.getEmpID());
			stmt.setString(2, (String)form.getDate());
			stmt.setString(3, form.getTime());
			stmt.setString(4, form.getLocation());
			stmt.setString(5, form.getDescription());
			stmt.setString(6, form.getCosts());
			stmt.setString(7, form.getGradingFormat());
			stmt.setString(8, form.getType());
			stmt.setString(9, form.getJustification());
			stmt.setInt(10, form.getUrgency());
			stmt.executeUpdate();

			stmt = conn.prepareStatement(INSERT_FORM_GSON);
			stmt.setObject(1, gson.toJson(form));
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			FormInsertionException newE = new FormInsertionException();
			newE.initCause(e);
			throw newE;
		}
		
	}

}
