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


@WebServlet("/listAll")
public class listAllController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public listAllController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		//session.setMaxInactiveInterval(30);
		if (session.getAttribute("id") != null) {
			
		DAOService service = new DAOServiceImpl();
		service.connectionDB();
		ResultSet result = service.saveAllReg();
		
		request.setAttribute("result", result);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/getAllRegistration.jsp");
		rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
