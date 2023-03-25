package com.studentappfinal.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentappfinal.model.DAOService;
import com.studentappfinal.model.DAOServiceImpl;


@WebServlet("/delete")
public class deleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public deleteController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		DAOService service = new DAOServiceImpl();
		service.connectionDB();
		service.deleteById(email);
		
		ResultSet result = service.saveAllReg();
		
		request.setAttribute("result", result);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/getAllRegistration.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
