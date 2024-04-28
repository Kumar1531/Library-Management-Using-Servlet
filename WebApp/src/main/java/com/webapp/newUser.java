package com.webapp;

import java.io.IOException;

import dao.InsertDao;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class newUser extends HttpServlet {
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		//get the values
		String name = req.getParameter("newName");
		String userName = req.getParameter("uname");
		long phoneNo =Long.parseLong(req.getParameter("pno"));
		String city = req.getParameter("city");
		String pass = req.getParameter("newPass");
		
		//create the object for the insertDao where we have the Sql codes
		InsertDao is = new InsertDao();
		
		//First check the if the username already exist. If the name already exist they need to enter the values
		if(is.checkUserName(userName,"user")) {
			res.sendRedirect("newUser.jsp");
		}
		//otherwise the values are added and redirected to the Login page
		else {
			is.addUserValue(name, userName,phoneNo, city, pass,"user");
			res.sendRedirect("Login.jsp");
		}
		
	}

}
