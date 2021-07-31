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
 * Servlet implementation class updateStudent
 */
@WebServlet("/loginsuccess/admin/updateStudent")
public class updateStudent extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "";
		String query = "";
		String usn = request.getParameter("usn").toUpperCase();
		Student student = new Student();
		Connection con = null;
		PreparedStatement st;
		try {
			con = makeconnection();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.print(e);
		}
		query = "SELECT * FROM Student WHERE USN='" + usn + "'";
		try {
			st = con.prepareStatement(query);
			//st.setString(1, usn);
			System.out.println(st);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				student.setUsn(rs.getString(1));
				student.setFirstname(rs.getString(2));
				student.setLastname(rs.getString(3));
				student.setDob(rs.getString(4));
				student.setGender(rs.getString(5).charAt(0));
				student.setDept(rs.getInt(6));
				student.setSem(rs.getInt(7));
				
				request.setAttribute("student", student);
				url = "/loginsuccess/admin/updateStudentDetails.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);
			}
			else {
				request.setAttribute("nreply", "Could not find student");
				url = "/loginsuccess/admin/updateStudent.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);
			}
		}catch(SQLException e){
			request.setAttribute("nreply", "Could not find student");
			url = "/loginsuccess/admin/updateStudent.jsp";
			getServletContext().getRequestDispatcher(url).forward(request, response);
			System.out.print(e);
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
