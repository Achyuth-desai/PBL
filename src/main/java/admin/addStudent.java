package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addStudent
 */
@WebServlet("/loginsuccess/admin/addStudent")
public class addStudent extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
						 throws ServletException, IOException {
		String url="";
		String query = "";
		String usn = request.getParameter("usn").toUpperCase();
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String dob = request.getParameter("dob");
		char gender = request.getParameter("gender").charAt(0);
		int dept = Integer.parseInt(request.getParameter("department"));
		int sem = Integer.parseInt(request.getParameter("semester"));
		
		Connection con = null;
		PreparedStatement st;
		try {
			con = makeconnection();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.print(e);
		}
		Student student = new Student(usn, firstname, lastname, gender, dob, dept, sem);
		query = "INSERT INTO Student(USN,FirstName,LastName,DOB,Gender,DeptID,SemID) VALUES(?, ?, ?, ?, ?, ?, ?);";
		try {
			st = con.prepareStatement(query);
			st.setString(1, usn);
			st.setString(2, firstname);
			st.setString(3, lastname);
			st.setString(4, dob);
			st.setString(5, String.valueOf(gender));
			st.setInt(6, dept);
			st.setInt(7, sem);
			int result = st.executeUpdate();
			request.setAttribute("preply", "Student Added!");
			url = "/loginsuccess/admin/addStudent.jsp";
			getServletContext().getRequestDispatcher(url).forward(request, response);
			System.out.println(st);
		} catch (SQLException e) {
			request.setAttribute("nreply", "Could not add student");
			url = "/loginsuccess/admin/addStudent.jsp";
			getServletContext().getRequestDispatcher(url).forward(request, response);
			System.out.print(e);
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			  throws ServletException, IOException {
		doPost(request, response);
	}
	private Connection makeconnection() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/studentdbms";
		String uname = "root";
		String pass = "Invoker@2000";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pass);
		return con;
	}
}
