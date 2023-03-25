package com.studentappfinal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.studentappfinal.model.DAOService;
import com.studentappfinal.model.DAOServiceImpl;


@WebServlet("/verifycredenial")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		DAOService service = new DAOServiceImpl();
		service.connectionDB();

		boolean status = service.verifyCredentials(id, password);
		try {
			if (status == true) {
				HttpSession session = request.getSession(true);
				session.setAttribute("id", id);
				//session.setMaxInactiveInterval(30);

				PrintWriter out = response.getWriter();
				out.println("Welcome!");
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/New_registration.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("error", "invalid id/password");

				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

}
