<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%
		if(session.getAttribute("username")==null){
			response.sendRedirect("/PBL");
		}
	%>
	<link href="https://fonts.googleapis.com/css?family=Inter&display=swap" rel="stylesheet" />
	<link href="admin.css" rel="stylesheet" />
	<title>Admin Page</title>
</head>
<body>
	<div class="v117_2">
		<div class="v117_3"></div>
		<div class="v117_4"></div>
        <span class="logo">College logo</span>
        <form action="Logout" method="post">
        	<input type="submit" class="log" value="LOGOUT">
        </form>
        <div id="student">
        	<h2>STUDENT</h2>
        	<form id="stuform" action="adminhome" method="post">
        		<input id="addstu"     name="action" type="submit" value="AddStudent">
        		<input id="viewdetstu" name="action" type="submit" value="ViewStudent">
        		<input id="updatestu"  name="action" type="submit" value="UpdateStudent">
        		<input id="removestu"  name="action" type="submit" value="RemoveStudent">
        	</form>
        </div>
        <div id="professor">
        	<h2>PROFESSOR</h2>
        	<form id="profform" action="adminhome" method="post">
        		<input id="addprof"     name="action" type="submit" value="AddFaculty">
        		<input id="viewdetprof" name="action" type="submit" value="ViewFaculty">
        		<input id="updateprof"  name="action" type="submit" value="UpdateFaculty">
        		<input id="removeprof"  name="action" type="submit" value="RemoveFaculty">
        	</form>
        </div>
        <div id="course">
        	<h2>COURSE</h2>
        	<form id="courform" action="adminhome" method="post">
        		<input id="addcour"     name="action" type="submit" value="AddCourse">
        		<input id="viewdetcour" name="aciton" type="submit" value="ViewCourse">
        		<input id="updatecour"  name="action" type="submit" value="UpdateCourse">
        		<input id="removecour"  name="action" type="submit" value="RemoveCourse">
        	</form>
        </div>

        <div class="footer"></div>
        <span class="contacts">For further queries contact </span>
        <span class="email">college@gmail.com</span>
        
       
        </div>
    </body>
    </html>