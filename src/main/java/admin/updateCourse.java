package admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class updateCourse
 */
@WebServlet("/loginsuccess/admin/updateCourse")
public class updateCourse extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
							throws ServletException, IOException {
		String url = "";
		String query = "";
		String courseid = request.getParameter("courseid").toUpperCase();
		Course course = new Course();
		Connection con = null;
		PreparedStatement st;
		try {
			con = makeconnection();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.print(e);
		}
		query = "SELECT * FROM Course WHERE CourseID=?";
		try {
			st = con.prepareStatement(query);
			st.setString(1, courseid);
			System.out.println(st);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				course.setCourseid(rs.getString(1));
				course.setCoursename(rs.getString(2));
				course.setCredits(rs.getInt(3));
				course.setDept(rs.getInt(4));
				course.setSem(rs.getInt(5));
				
				request.setAttribute("course", course);
				url = "/loginsuccess/admin/updateCourseDetails.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);
			}
			else {
				request.setAttribute("nreply", "Could not find course");
				url = "/loginsuccess/admin/updateCourse.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);
			}
		}catch(SQLException e){
			request.setAttribute("nreply", "Could not upate course");
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
