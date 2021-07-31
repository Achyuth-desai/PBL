package login;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class EmailCheckServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request,
						  HttpServletResponse response)
						  throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String url = "/index.jsp";
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		if(action=="null") {
			action = "login";
		}
		if(action.equals("login")) {
			url = "/index.jsp";
		}
		else if(action.equals("add")) {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			int loginas = Integer.parseInt(request.getParameter("loginas"));
			
			User user = new User(email, password, loginas);
			
			boolean result=false;
			try {
				result = validateUser(user);
			}catch(Exception ex) {
				System.out.println(ex);
			}
			
			if(result == true) {
				session.setAttribute("username", user.getEmail());
				if(user.getUser()==1) {
					response.sendRedirect("loginsuccess/admin/admin.jsp");
				}
				if(user.getUser()==2) {
					response.sendRedirect("loginsuccess/student/student.jsp");
				}
				if(user.getUser()==3) {
					response.sendRedirect("loginsuccess/teacher/teacher.jsp");
				}
			}
			else {
				request.setAttribute("message", "Incorrect username or password");
				url = "/index.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);
			}
		}
	}
	protected void doGet(HttpServletRequest request,
						 HttpServletResponse response) throws
						 ServletException, IOException{
		doPost(request, response);
	}
	
	public boolean validateUser(User user) throws Exception {
		String email = user.getEmail();
		String query = "";	
		Connection con = makeconnection();
		if(user.getUser()==1) {
			query = "SELECT passwords FROM admin WHERE emailid=(?)";
		}
		if(user.getUser()==2) {
			query = "SELECT passwords FROM teacher WHERE emailid=(?)";
		}
		if(user.getUser()==3) {
			query = "SELECT passwords FROM student WHERE emailid=(?)";
		}
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1, email);
		ResultSet rs = st.executeQuery();
		rs.next();
		
		String password = rs.getString(1);
		if(password.equals(user.getPassword())) {
			return true;
		}
		return false;
	}
	private Connection makeconnection() throws Exception {
		String url = "jdbc:mysql://localhost:3306/login";
		String uname = "root";
		String pass = "Invoker@2000";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pass);
		return con;
	}
}

