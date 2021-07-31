<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet" />
	<link href="style.css" rel="stylesheet" />
	<title>Data Management System | Home</title>
</head>
<body>
	<div class="main">
		<div class="logb"></div>
		<div class="details"></div>
		<div class="nav"></div>
		<span class="home">Home</span>
		<div class="logo"></div>
		<span class="head">Welcome to Student Management System</span>
	
		<span class="log">Log In</span>
		
		<form id="form" action="login" method="post">
		<input type="hidden" name="action" value="add" autocomplete="off">
		
		<p style="color:red">${message}</p>
		<label id="ma">Email  </label>
		<input id="il" type="email" name="email"  required autofocus><br>
		
		<label id="passw">Password  </label>
		<input id="ord" type="password" name="password"  required><br>
		
		<label id="lo">Designation </label>
		<select class="gin" name="loginas" id="loginas">
			<option style="display:none"></option>
			<option value=1>Admin</option>
			<option value=2>Teacher</option>
			<option value=3>Student</option>
		</select><br><br>
		<label id="logbut">&nbsp;</label>
		<input class="logbut" type="submit" value="Proceed" id="Login" >
	</form>
		
		<!-- <div class="foot"></div>
		<span class="query">For further queries contact </span>
		<span class=coll>college@gmail.com</span>
		<span class="forgot">Forgot Password ?</span>   --->    
	</div>
</body>
</html>