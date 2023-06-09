package com.studentappfinal.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.studentappfinal.model.DAOService;
import com.studentappfinal.model.DAOServiceImpl;


@WebServlet("/update")
public class updateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public updateController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		request.setAttribute("email", email);
		request.setAttribute("mobile", mobile);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/updateReg.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			//session.setMaxInactiveInterval(30);
			if (session.getAttribute("id") != null) {

				String email = request.getParameter("email");
				String mobile = request.getParameter("mobile");

				DAOService service = new DAOServiceImpl();
				service.connectionDB();
				service.updateRecord(email, mobile);

				ResultSet result = service.saveAllReg();

				request.setAttribute("result", result);

				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/getAllRegistration.jsp");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

}
