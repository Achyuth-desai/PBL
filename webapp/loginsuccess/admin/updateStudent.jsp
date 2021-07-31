<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link href="https://fonts.googleapis.com/css?family=Inter&display=swap" rel="stylesheet" />
	<title>Update Student</title>
	<link href="updateStudent.css" rel="stylesheet" />
</head>
<body>
<%
		if(session.getAttribute("username")==null){
			response.sendRedirect("/PBL");
		}
	%>
	<div class="v126_30">
		<div class="v126_31"></div>
		<div class="v126_32"></div>
		<span class="logo">College logo</span>
		<form action="Logout" method="post">
        	<input type="submit" class="log" value="LOGOUT">
        </form>
		<span class="head">Enter Student USN</span>
		<div id="form">
			<form action="updateStudent" method="post">
		<input type="hidden" name="action" value="add" autocomplete="off">
		<p style="color:green; font-size:18px;">${preply}</p>
		<p style="color:red; font-size:18px;">${nreply}</p>	
		<label>Enter USN : </label>
		<input id="usn" type="text" name="usn" required="on" ><br>
		
		<label>&nbsp;</label>
		<input id="updstu" type="submit" value="Proceed">
	</form>
		<!-- </div>
		<div class="footer"></div>
		<span class="contact">For further queries contact </span>
		<span class="mail">college@gmail.com</span>
	</div> -->
</body>
</html>