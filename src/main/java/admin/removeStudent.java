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
 * Servlet implementation class removeStudent
 */
@WebServlet("/loginsuccess/admin/removeStudent")
public class removeStudent extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
							throws ServletException, IOException {
		String url = "";
		String query = "";
		String usn = request.getParameter("usn").toUpperCase();
		Connection con = null;
		PreparedStatement st;
		try {
			con = makeconnection();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.print(e);
		}
		query = "DELETE FROM Student WHERE USN=(?);";
		try {
			st = con.prepareStatement(query);
			st.setString(1, usn);
			int result = st.executeUpdate();
			if(result>0) {
				request.setAttribute("preply", "Student Removed!");
				url = "/loginsuccess/admin/removeStudent.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);
				System.out.println(st);
			}
			else {
				request.setAttribute("nreply", "Could not remove student");
				url = "/loginsuccess/admin/removeStudent.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);
			}
		}catch(SQLException e){
			request.setAttribute("nreply", "Could not remove student");
			url = "/loginsuccess/admin/removeStudent.jsp";
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
