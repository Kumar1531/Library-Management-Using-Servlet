package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InsertDao {
	
	String qry = "insert into login(Name,UserName,Password,PhoneNo,City) values(?,?,?,?)";
	String url = "jdbc:mysql://localhost:3306/jsp";
	String username = "root";
	String password = "sabari";
	
	public void addUserValue(String name,String userName,long phoneNo,String city,String pass,String pos) {
		
		if(pos.equalsIgnoreCase("user")) {
			qry = "insert into login(Name,UserName,Password,PhoneNo,City) values(?,?,?,?,?)";
		}
		else {
			qry = "insert into adminlogin(Name,UserName,Password,PhoneNo,City) values(?,?,?,?,?)";
		}
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url,username,password);
			
			PreparedStatement ps = con.prepareStatement(qry);
			
			ps.setString(1, name);
			ps.setString(2, userName);
			ps.setString(3, pass);
			ps.setLong(4, phoneNo);
			ps.setString(5, city);
			
			ps.executeUpdate();
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public boolean checkUserName(String name,String pos) {
		
		if(pos.equalsIgnoreCase("user")) {
			qry = "select * from login where UserName = ?";
		}
		else {
			qry = "select * from adminlogin where UserName = ?";
		}
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url,username,password);
			
			PreparedStatement ps = con.prepareStatement(qry);
			
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return true;
			}
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	public void insertBook(String bookName,String authorName,String journer) {
		
		qry = "insert into books(bookName,Author,Journer) values(?,?,?)";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url,username,password);
			
			PreparedStatement ps = con.prepareStatement(qry);
			
			ps.setString(1, bookName);
			ps.setString(2,authorName);
			ps.setString(3, journer);
			
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean checkBookName(String bookName) {
		
		qry = "select * from books where BookName = ?";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url,username,password);
			
			PreparedStatement ps = con.prepareStatement(qry);
			
			ps.setString(1, bookName);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return true;
			}
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	public void removeBook(int id ,String book) {
		
		qry = "delete from books where id = ?";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url,username,password);
			
			PreparedStatement ps = con.prepareStatement(qry);
			
			ps.setInt(1, id);
	
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
