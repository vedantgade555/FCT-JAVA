package com;
import java.io.*;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/ServletConfigClass")
public class ServletConfigClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ServletConfigClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		ServletConfig config = getServletConfig();
		
		String n = config.getInitParameter("name");
		String s = config.getInitParameter("surname");
		pw.print("Init Parameter is "+n+" "+s);
		
		

		ServletContext context = getServletContext();
		String p = context.getInitParameter("Project");
		pw.println("Context Parameter is: "+p);
		
		pw.close();
	}

}
