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
 * Servlet implementation class updateFaculty
 */
@WebServlet("/loginsuccess/admin/updateFaculty")
public class updateFaculty extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "";
		String query = "";
		String id = request.getParameter("id").toUpperCase();
		Faculty faculty = new Faculty();
		Connection con = null;
		PreparedStatement st;
		try {
			con = makeconnection();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.print(e);
		}
		query = "SELECT * FROM Faculty WHERE FacultyID=?";
		try {
			st = con.prepareStatement(query);
			st.setString(1, id);
			System.out.println(st);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				faculty.setFacultyid(rs.getString(1));
				faculty.setfirstname(rs.getString(2));
				faculty.setlastname(rs.getString(3));
				faculty.setDept(rs.getInt(4));
				
				request.setAttribute("faculty", faculty);
				url = "/loginsuccess/admin/updateFacultyDetails.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);
			}
			else {
				request.setAttribute("nreply", "Could not find faculty");
				url = "/loginsuccess/admin/updateFaculty.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);
			}
		}catch(SQLException e){
			request.setAttribute("nreply", "Could not find faculty");
			url = "/loginsuccess/admin/updateFaculty.jsp";
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
