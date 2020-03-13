package com.moflexy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.moflexy.domain.Employee;
import com.moflexy.domain.Employee.EmployeeType;
import com.moflexy.service.AuthenticationService;
import com.moflexy.service.AuthenticationServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static AuthenticationService authService = new AuthenticationServiceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("Username: " + username + " Password: " + password);
		Employee emp = authService.validateUser(username, password);
		if (emp == null) {
			response.setStatus(response.SC_UNAUTHORIZED);
			System.out.println("Denied !");
		} else {
			System.out.println(emp.toString());
			HttpSession sess = request.getSession(true);
			sess.setAttribute(emp.getUsername(), emp);
			switch(emp.getType()) {
			case BENCO:
			case SUPERVISOR:
			case DEPT_HEAD:
				response.sendRedirect("http://localhost:8080/TuitionReimbursement/pages/manager.html");
				break;
			case STANDARD:
				response.sendRedirect("http://localhost:8080/TuitionReimbursement/pages/completeform.html");
			}
			System.out.println("Access granted! :)");
		}
	}
}
