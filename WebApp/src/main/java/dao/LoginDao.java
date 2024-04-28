package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
	String qry = "select * from login where UserName = ? and Password = ?";
	String url = "jdbc:mysql://localhost:3306/jsp";
	String username = "root";
	String password = "sabari";
	
	public boolean check(String name,String pass,String pos) {
		
		if(pos.equalsIgnoreCase("user")) {
			qry = "select * from login where UserName = ? and Password = ?";
		}
		else {
			qry = "select * from adminlogin where UserName = ? and Password = ?";
		}
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url,username,password);
			
			PreparedStatement ps = con.prepareStatement(qry);
			
			ps.setString(1, name);
			ps.setString(2, pass);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
		
	}

}
