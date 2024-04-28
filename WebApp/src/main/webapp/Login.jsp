<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
<link rel= "stylesheet" href = "style.css">
</head>
<body>

<div class = "hero">
	<div class = "form-box">
		<div class = "button-box">
			<div id = "btn"></div>
			<button type="button" class = "toggle-btn" onclick = "admin()">Admin</button>
			<button type="button" class = "toggle-btn" onclick = "user()">User</button>
		</div>
		<form id = "login" action="adminLogin" class = "input-group">
	
		Enter the name : <input type = "text" class = "input-field" name = "name">
		Enter the password : <input type = "password" class = "input-field" name = "pass">
		<input type = "submit" value = "LOG IN" class = "btn">
		<br>
		<br>
		Create a New Account <a href ="newAdmin.jsp">Sign up</a>
		
		</form>

		<form id = "register" action="login" class = "input-group">
	
		Enter the name : <input type = "text" class = "input-field" name = "name">
		Enter the password : <input type = "password" class = "input-field" name = "pass">
		<input type = "submit" value = "LOG IN" class = "btn">
		<br>
		<br>
		Create a New Account <a href ="newUser.jsp">Sign up</a>
		
		</form>
		
	</div>
</div>

	<script>
	
		var x = document.getElementById("login");
		var y = document.getElementById("register");
		var z = document.getElementById("btn");
		
		function user(){
			x.style.left = "-400px";
			y.style.left = "50px";
			z.style.left = "110px";
		}
		
		function admin(){
			x.style.left = "50px";
			y.style.left = "450px";
			z.style.left = "0px";
		}
	
	</script>
	

</body>
</html>