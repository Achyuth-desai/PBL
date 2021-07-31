package admin;

import java.io.IOException;
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
 * Servlet implementation class addCourse
 */
@WebServlet("/loginsuccess/admin/addCourse")
public class addCourse extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
							throws ServletException, IOException {		
		String url="";
		String query = "";
		String courseid = request.getParameter("courseid").toUpperCase();
		String coursename = request.getParameter("coursename");
		int credits = Integer.parseInt(request.getParameter("credits"));
		int dept = Integer.parseInt(request.getParameter("department"));
		int sem = Integer.parseInt(request.getParameter("semester"));

		Connection con = null;
		PreparedStatement st;
		try {
			con = makeconnection();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.print(e);
		}
		
		Course course = new Course(courseid, coursename, credits, dept, sem);
		
		query = "INSERT INTO Course(CourseID, CourseName, Credits, DeptID, SemID) VALUES(?, ?, ?, ?, ?);";
		try {
			st = con.prepareStatement(query);
			st.setString(1, courseid);
			st.setString(2, coursename);
			st.setInt(3, credits);
			st.setInt(4, dept);
			st.setInt(5, sem);
			int result = st.executeUpdate();
			request.setAttribute("preply", "Course Added!");
			url = "/loginsuccess/admin/addCourse.jsp";
			getServletContext().getRequestDispatcher(url).forward(request, response);
			System.out.println(st);
		} catch (SQLException e) {
			request.setAttribute("nreply", "Could not add course");
			url = "/loginsuccess/admin/addCourse.jsp";
			getServletContext().getRequestDispatcher(url).forward(request, response);
			System.out.print(e);
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
							throws ServletException, IOException {
		// TODO Auto-generated method stub
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
