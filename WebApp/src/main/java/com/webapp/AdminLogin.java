package com.webapp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import dao.LoginDao;

/**
 * Servlet implementation class AdminLogin
 */

@WebServlet("/adminLogin")
public class AdminLogin extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String pass = req.getParameter("pass");
		
		LoginDao lg = new LoginDao();
		
		//Check the values are correct by using the method we have created in LoginDao class		
		boolean check = lg.check(name, pass,"admin");
		
		if(check){
			
			//If they Login then add the name in the session then we can use the name throughout the session
			HttpSession session = req.getSession();
			
			session.setAttribute("name", name);
			
			res.sendRedirect("adminHome.jsp");
			
		}
		else {
			res.sendRedirect("Login.jsp");
		}
		
	}


}
