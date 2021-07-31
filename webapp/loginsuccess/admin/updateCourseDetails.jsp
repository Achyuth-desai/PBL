<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link href="https://fonts.googleapis.com/css?family=Inter&display=swap" rel="stylesheet" />
	<title>Update Course</title>
	<link href="addCourse.css" rel="stylesheet" />
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
		<span class="head">Enter Course Details</span>
		<div id="form">
			<form action="updateCourseDetails" method="post">
		<input type="hidden" name="action" value="add" autocomplete="off">
		<p style="color:green; font-size:18px;">${preply}</p>
		<p style="color:red; font-size:18px;">${nreply}</p>	
		<label>Course ID : </label>
		<input id="cid" type="text" name="courseid" required="on" value=${course.courseid} readonly="readonly"><br>
		<label>Course Name : </label> 
		<input id="cname" type="text" name="coursename" required="on" value=${course.coursename}><br>
		<label>Credits :</label>
		<select id="sem" name="credits">
			<option style="display:none"></option>
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
		</select><br>
		<label>Department : </label>
		<select id="dept" name="department">
			<option style="display:none"></option>
			<option value="1">Computer Science Engineering</option>
			<option value="2">Electronics and Communication Engineering</option>
			<option value="3">Mechanical Engineering</option>
			<option value="4">Civil Engineering</option>
		</select><br>
		<label>Semester : </label>
		<select id="sem" name="semester">
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
		<input id="addcou" type="submit" value="Update Course">
	</form>
	</div>
</body>
</html>