package admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginsuccess/admin/adminhome")
public class adminHome extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
							throws ServletException, IOException{
		//getServletContext().getRequestDispatcher("/loginsuccess/admin/admin.jsp").forward(request, response);
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		String url = "";
		if(action.equals("null")) {
			url = "/loginsuccess/admin/admin.jsp";
		}
		if(action.equals("AddStudent")) {
			url = "/loginsuccess/admin/addStudent.jsp";
		}
		if(action.equals("UpdateStudent")) {
			url = "/loginsuccess/admin/updateStudent.jsp";
		}
		if(action.equals("RemoveStudent")) {
			url = "/loginsuccess/admin/removeStudent.jsp";
		}
		if(action.equals("AddFaculty")) {
			url = "/loginsuccess/admin/addFaculty.jsp";
		}
		if(action.equals("UpdateFaculty")) {
			url = "/loginsuccess/admin/updateFaculty.jsp";
		}
		if(action.equals("RemoveFaculty")) {
			url = "/loginsuccess/admin/removeFaculty.jsp";
		}
		if(action.equals("AddCourse")) {
			url = "/loginsuccess/admin/addCourse.jsp";
		}
		if(action.equals("UpdateCourse")) {
			url = "/loginsuccess/admin/updateCourse.jsp";
		}
		if(action.equals("RemoveCourse")) {
			url = "/loginsuccess/admin/removeCourse.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
							throws ServletException, IOException{
		doPost(request, response);
	}
}
