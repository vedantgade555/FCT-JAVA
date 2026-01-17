package com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		
		String pid = request.getParameter("page");
		int pageId = Integer.parseInt(pid);
		
		int pageLimit = 5;
		
		if(pageId==1) {}
		else 
		{
			pageId = pageId-1;
			pageId = pageId*pageLimit+1;
			
		}
		
		List<Emp> list = EmpDao.getRecords(pageId,pageLimit);
		
		
		pw.print("<h1>Page No: " + pageId + "</h1>");

        pw.print("<table border='1' cellpadding='5' width='60%'>");
        pw.print("<tr>"
                + "<th>ID</th>"
                + "<th>Name</th>"
                + "<th>Country</th>"
                + "</tr>");

        for (Emp e : list) {
            pw.print("<tr>");
            pw.print("<td>" + e.getId() + "</td>");
            pw.print("<td>" + e.getName() + "</td>");
            pw.print("<td>" + e.getCountry() + "</td>");
            pw.print("</tr>");
        }

        pw.print("</table><br>");

        // Pagination links
        pw.print("<a href='ViewServlet?page=1'>1</a> ");
        pw.print("<a href='ViewServlet?page=2'>2</a> ");
        pw.print("<a href='ViewServlet?page=3'>3</a>");

        pw.close();
		
		
	}


}
