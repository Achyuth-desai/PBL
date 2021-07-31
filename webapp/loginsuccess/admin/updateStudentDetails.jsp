<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link href="https://fonts.googleapis.com/css?family=Inter&display=swap" rel="stylesheet" />
	<title>Update Student</title>
	<link href="addStudent.css" rel="stylesheet" />
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
		<span class="head">Enter Student Details</span>
		
		<div id="form">
			<form action="updateStudentDetails" method="post">
		<input type="hidden" name="action" value="add" autocomplete="off">
		<p style="color:green; font-size:18px;">${preply}</p>
		<p style="color:red; font-size:18px;">${nreply}</p>	
		<label>USN : </label>
		<input id="usn" type="text" name="usn" required="on" value=${student.usn} readonly="readonly"><br>
		<label>First Name : </label> 
		<input id="fname" type="text" name="firstname" required="on" value=${student.firstname}><br>
		<label>Last Name : </label>	
		<input id="lname" type="text" name="lastname" required="on" value=${student.lastname}><br>
		<label>Gender : </label>
		<select id="gender" name="gender" id="gender" value=${student.gender}> 
			<option style="display:none"></option>
			<option value="M">Male</option>
			<option value="F">Female</option>
			<option value="N">Other</option>
		</select><br>
		<label>Date of Birth : </label>
		<input id="date" type="date" name="dob" required="on" value=${student.dob}><br>
		<label>Department : </label>
		<select id="dept" name="department" value=${student.dept}>
			<option style="display:none"></option>
			<option value="1">Computer Science Engineering</option>
			<option value="2">Electronics and Communication Engineering</option>
			<option value="3">Mechanical Engineering</option>
			<option value="4">Civil Engineering</option>
		</select><br>
		<label>Semester : </label>
		<select id="sem" name="semester" value=${student.sem}>
			<option style="display:none"></option>
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
			<option value="7">7</option>
			<option value="8">8</option>
		</select><br>
		<label>&nbsp;</label>
		<input id="addstu" type="submit" value="Update Student">
	</form>
		<!-- </div>
		<div class="footer"></div>
		<span class="contact">For further queries contact </span>
		<span class="mail">college@gmail.com</span> -->
		
	</div>
</body>
</html>