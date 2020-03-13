package com.moflexy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.GsonBuilder;
import com.moflexy.dao.FormDAOPostgres;
import com.moflexy.domain.Form;
import com.moflexy.service.FormService;
import com.moflexy.service.FormServiceImpl;

public class AllFormsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5513694189648046330L;
	FormService formService = new FormServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sess = req.getSession(false);
		Form form = new Form();
		form.setEmpID((int)Integer.parseInt(sess.getAttribute("eid").toString()));
		form.setDate((String)sess.getAttribute("date"));
		form.setTime(sess.getAttribute("time").toString());
		form.setLocation(sess.getAttribute("location").toString());
		form.setCosts(sess.getAttribute("cost").toString());
		form.setDescription(sess.getAttribute("description").toString());
		form.setGradingFormat(sess.getAttribute("format").toString());
		form.setJustification(sess.getAttribute("justification").toString());
		String formJSON = new GsonBuilder().create().toJson(form);
		PrintWriter pw = resp.getWriter();
		pw.write(formJSON);
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
