package test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.print("<h1>Update Employee</h1>");
		
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		
		Emp e = EmpDao.getElementById(id);
		
		pw.print("<form action='EditServlet2' method='post'>");
		pw.print("<table>");

		pw.print("<tr><td></td><td><input type='hidden' name='id' value='" + e.getId() + "'></td></tr>");

		pw.print("<tr><td>Name: </td><td><input type='text' name='name' value='" + e.getName() + "'></td></tr>");

		pw.print("<tr><td>Password: </td><td><input type='text' name='password' value='" + e.getPassword() + "'></td></tr>");

		pw.print("<tr><td>Email: </td><td><input type='text' name='email' value='" + e.getEmail() + "'></td></tr>");

		pw.print("<tr><td>Country: </td><td>");
		pw.print("<select name='country' style='width:150px'>");
		pw.print("<option>India</option>");
		pw.print("<option>USA</option>");
		pw.print("<option>UK</option>");
		pw.print("<option>Russia</option>");
		pw.print("</select>");
		pw.print("</td></tr>");

		pw.print("<tr><td colspan='2'><input type='submit' value='Edit & Save'></td></tr>");

		pw.print("</table>");
		pw.print("</form>");

	}

}
