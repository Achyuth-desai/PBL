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


@WebServlet("/loginsuccess/admin/updateCourseDetails")
public class updateCourseDetails extends HttpServlet {
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
		query = "UPDATE Course SET CourseName=?, Credits=?, DeptID=?, SemID=? where CourseID=?";
		try {
			st = con.prepareStatement(query);
			st.setString(1, coursename);
			st.setInt(2, credits);
			st.setInt(3, dept);
			st.setInt(4, sem);
			st.setString(5, courseid);
			int result = st.executeUpdate();
			if(result>0) {
				request.setAttribute("preply", "Course Updated!");
				url = "/loginsuccess/admin/updateCourse.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);
				System.out.println(st);
			}
			else {
				request.setAttribute("nreply", "Could not find course");
				url = "/loginsuccess/admin/updateCourse.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);
			}
		}catch(SQLException e) {
			request.setAttribute("nreply", "Could not update course");
			url = "/loginsuccess/admin/updateCourse.jsp";
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
