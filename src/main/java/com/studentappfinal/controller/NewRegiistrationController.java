package com.studentappfinal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.studentappfinal.model.DAOService;
import com.studentappfinal.model.DAOServiceImpl;

@WebServlet("/newReg")
public class NewRegiistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public NewRegiistrationController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/New_registration.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			//session.setMaxInactiveInterval(30);
			if (session.getAttribute("id") != null) {

				String Name = request.getParameter("name");
				String City = request.getParameter("city");
				String Email = request.getParameter("email");
				String Mobile = request.getParameter("mobile");

				DAOService service = new DAOServiceImpl();
				service.connectionDB();
				service.saveReg(Name, City, Email, Mobile);

				request.setAttribute("msg", "Record is SAVE!!!");

				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/New_registration.jsp");
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
