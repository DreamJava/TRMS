package com.moflexy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.moflexy.dao.FormDAO;
import com.moflexy.dao.FormDAOPostgres;
import com.moflexy.domain.Employee;
import com.moflexy.domain.Form;
import com.moflexy.exception.FormInsertionException;
import com.moflexy.service.AuthenticationService;
import com.moflexy.service.AuthenticationServiceImpl;
import com.moflexy.service.FormService;
import com.moflexy.service.FormServiceImpl;

public class CompleteFormServlet extends HttpServlet {

    
	private static AuthenticationService authService = new AuthenticationServiceImpl();
	
	FormService formService = new FormServiceImpl();
	FormDAOPostgres formDAO = new FormDAOPostgres();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int empID = Integer.parseInt(request.getParameter("eid"));
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String location = request.getParameter("location");
		String description = request.getParameter("description"); 
		String costs = request.getParameter("cost");
		String format = request.getParameter("format");
		String type = request.getParameter("type");
		String justification = request.getParameter("justification");
		int urgency = 0;
		Form form = new Form(empID, date, time, location, description, costs, format, type, justification, urgency);
		try {
			formDAO.insertForm(form);
		} catch (FormInsertionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Form added! :)");
		response.sendRedirect("http://localhost:8080/TuitionReimbursement/pages/formsubmitted.html");
		
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		System.out.println("Username: " + username + " Password: " + password);
//		Employee emp = authService.validateUser(username, password);
//		if (emp == null) {
//			response.setStatus(response.SC_UNAUTHORIZED);
//			System.out.println("Denied !");
//		} else {
//			System.out.println(emp.toString());
//			HttpSession sess = request.getSession(true);
//			sess.setAttribute(emp.getUsername(), emp);
//			switch(emp.getType()) {
//			case BENCO:
//			case SUPERVISOR:
//			case DEPT_HEAD:
//				response.sendRedirect("http://localhost:8080/TuitionReimbursement/pages/manager.html");
//				break;
//			case STANDARD:
//				response.sendRedirect("http://localhost:8080/TuitionReimbursement/pages/completeform.html");
//			}
		}
	
	public void setFormService(FormService formService) {
		this.formService = formService;
	}

}
