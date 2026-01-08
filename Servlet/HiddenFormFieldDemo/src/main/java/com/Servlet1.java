package com;
import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			
			PrintWriter pw = response.getWriter();
			String s = request.getParameter("username");
			pw.print("Welcome "+s);
			
			pw.print("<form action='Servlet2' method='get'>");
			pw.print("<input type='hidden' name='hfield' value=' "+s+" '>");
			pw.print("<input type='submit' value='Visit'>");
			pw.print("</form>");
			
			pw.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
