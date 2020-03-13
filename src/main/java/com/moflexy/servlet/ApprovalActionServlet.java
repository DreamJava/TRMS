package com.moflexy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.GsonBuilder;
import com.moflexy.domain.Employee;
import com.moflexy.domain.Form;
import com.moflexy.service.FormService;
import com.moflexy.service.FormServiceImpl;

public class ApprovalActionServlet extends HttpServlet {

	FormService formService = new FormServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Form> formList = formService.getAllForms();
		String formListJSON = new GsonBuilder().create().toJson(formList);
		PrintWriter pw = resp.getWriter();
		pw.write(formListJSON);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
//		System.out.println("Username: " + username + " Password: " + password);
//		Employee emp = authService.validateUser(username, password);
//		if (emp == null) {
//			response.setStatus(response.SC_UNAUTHORIZED);
//			System.out.println("Denied !");
//		} else {
//			System.out.println(emp.toString());
		
//			HttpSession sess = request.getSession(true);
//			sess.setAttribute(emp.getUsername(), emp);
//
//		switch(emp.getType()) {
//			case BENCO:
//			case SUPERVISOR:
//			case DEPT_HEAD:
//				response.sendRedirect("http://localhost:8080/TuitionReimbursement/pages/manager.html");
//			}
//			System.out.println("Access granted! :)");
//		}
	}

	public void setFormService(FormService formService) {
		this.formService = formService;
	}

}
