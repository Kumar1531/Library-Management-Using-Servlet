package dao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/newAd")
public class newAdmin extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get the values
				String name = req.getParameter("newName");
				String userName = req.getParameter("uname");
				long phoneNo =Long.parseLong(req.getParameter("pno"));
				String city = req.getParameter("city");
				String pass = req.getParameter("newPass");
				String key = req.getParameter("key");
				
				//create the object for the insertDao where we have the Sql codes
				InsertDao is = new InsertDao();
						
				//First check the if the username already exist if exist the again need to enter the values
				if(is.checkUserName(userName,"admin")) {
					res.sendRedirect("newAdmin.jsp");
				}
				//otherwise the values are added and redirected to the Login page
				else {
					is.addUserValue(name, userName,phoneNo, city, pass,"admin");
					res.sendRedirect("Login.jsp");
				}
	}


}
