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
 * Servlet implementation class updateFacultyDetails
 */
@WebServlet("/loginsuccess/admin/updateFacultyDetails")
public class updateFacultyDetails extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
							throws ServletException, IOException {
		String url="";
		String query = "";
		String id = request.getParameter("facultyid").toUpperCase();
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		int dept = Integer.parseInt(request.getParameter("department"));
		Connection con = null;
		PreparedStatement st;
		try {
			con = makeconnection();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.print(e);
		}
		query = "UPDATE Faculty SET FirstName=?, LastName=?, DeptID=? where FacultyID=?";
		try {
			st = con.prepareStatement(query);
			st.setString(1, firstname);
			st.setString(2, lastname);
			st.setInt(3, dept);
			st.setString(4, id);
			int result = st.executeUpdate();
			if(result>0) {
				request.setAttribute("preply", "Faculty Updated!");
				url = "/loginsuccess/admin/updateFaculty.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);
				System.out.println(st);
			}
			else {
				request.setAttribute("nreply", "Could not update faculty");
				url = "/loginsuccess/admin/updateFaculty.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);
			}
		}catch(SQLException e) {
			request.setAttribute("nreply", "Could not update faculty");
			url = "/loginsuccess/admin/updateFacutly.jsp";
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
