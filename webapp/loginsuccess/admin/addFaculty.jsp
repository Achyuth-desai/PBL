<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link href="https://fonts.googleapis.com/css?family=Inter&display=swap" rel="stylesheet" />
	<title>Add Faculty</title>
	<link href="addFaculty.css" rel="stylesheet" />
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
		<span class="head">Add Faculty Details</span>
		<div id="form">
			<form action="addFaculty" method="post">
		<input type="hidden" name="action" value="add" autocomplete="off">
		<p style="color:green; font-size:18px;">${preply}</p>
		<p style="color:red; font-size:18px;">${nreply}</p>	
		<label>Faculty ID : </label>
		<input id="id" type="text" name="facultyid" required="on"><br>
		<label>First Name : </label> 
		<input id="fname" type="text" name="firstname" required="on" ><br>
		<label>Last Name : </label>	
		<input id="lname" type="text" name="lastname" required="on" ><br>
		
		<label>Department : </label>
		<select id="dept" name="department">
			<option style="display:none"></option>
			<option value="1">Computer Science Engineering</option>
			<option value="2">Electronics and Communication Engineering</option>
			<option value="3">Mechanical Engineering</option>
			<option value="4">Civil Engineering</option>
		</select><br>
		
		<label>&nbsp;</label>
		<input id="addfac" type="submit" value="Add Faculty">
	</form>
		</div>
		<div class="footer"></div>
		<span class="contact">For further queries contact </span>
		<span class="mail">college@gmail.com</span>
		
	</div>
</body>
</html>