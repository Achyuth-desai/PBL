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
 * Servlet implementation class updateStudentDetails
 */
@WebServlet("/loginsuccess/admin/updateStudentDetails")
public class updateStudentDetails extends HttpServlet {
	
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
		query = "UPDATE Student SET FirstName=?, LastName=?,Dob=?, Gender=?, DeptID=?, SemID=? where USN=?";
		try {
			st = con.prepareStatement(query);
			st.setString(1, firstname);
			st.setString(2, lastname);
			st.setString(3, dob);
			st.setString(4, String.valueOf(gender));
			st.setInt(5, dept);
			st.setInt(6, sem);
			st.setString(7, usn);
			int result = st.executeUpdate();
			if(result>0) {
				request.setAttribute("preply", "Student Updated!");
				url = "/loginsuccess/admin/updateStudent.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);
				System.out.println(st);
			}
			else {
				request.setAttribute("nreply", "Could not update student");
				url = "/loginsuccess/admin/updateStudent.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);
			}
		}catch(SQLException e){
			request.setAttribute("nreply", "Could not update student");
			url = "/loginsuccess/admin/updateStudent.jsp";
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
