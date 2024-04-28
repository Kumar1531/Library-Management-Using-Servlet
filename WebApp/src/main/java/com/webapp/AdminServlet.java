package com.webapp;

import java.io.IOException;

import dao.InsertDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/aserv")
public class AdminServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String bname = req.getParameter("bname");
		String aname = req.getParameter("aname");
		String journer = req.getParameter("journer");
		
		InsertDao is = new InsertDao();
		
		if(!is.checkBookName("bname")) {
			is.insertBook(bname, aname, journer);
			res.sendRedirect("adminHome.jsp");
		}
		else {
			res.sendRedirect("adminHome.jsp");
		}
		
	}

}
