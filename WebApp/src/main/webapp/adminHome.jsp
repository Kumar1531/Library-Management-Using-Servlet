<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADMIN HOME</title>
<link rel = "stylesheet" href = "admin.css">
</head>
<body>

<%

	response.setHeader("Cache-Control", "no-cache no-store must-revalidate");

	response.setHeader("Pragma", "no-cache");
	
	response.setHeader("Expires","0");

%>

<div class = "form">
	<div class = "box1">
		Insert a New Book<br><br>
		<form action="aserv">
			
			Enter the BookName : <input type = "text" name = "bname"><br><br>
			Enter the Author Name : <input type = "text" name = "aname"><br><br>
			Enter the Journer : <input type = "text" name = "journer"><br><br>
			<input type = "submit" value = "INSERT">
			
		</form>
	</div>

	<div class = "box2">
		Remove a Book<br><br>
		<form action="aremove">
			
			Enter the Id : <input type = "text" name = "id"><br><br>
			Enter the Book Name : <input type = "text" name = "dname"><br><br>
			<input type = "submit" value = "DELETE">
			
		</form>
	</div>
</div>

</body>
</html>