package com.webapp;

import java.io.IOException;

import dao.InsertDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/aremove")
public class AdminRemoveServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String bname = req.getParameter("dname");
		
		InsertDao is = new InsertDao();
		
		is.removeBook(id, bname);
		
		res.sendRedirect("adminHome.jsp");
		
	}

}
