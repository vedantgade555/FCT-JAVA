package com;
import java.io.*;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String n = request.getParameter("uname");
		pw.print("Welcome "+n);
		
		request.setAttribute("surname", "Gade");
		
		request.getRequestDispatcher("Servlet2").forward(request, response);
//		Here the same request will forwarded to next servlet
		
		
		HttpSession session = request.getSession();
		session.setAttribute("dname", "Admin");
		
		
		ServletContext context = getServletContext();
		context.setAttribute("sname", "Sam");
	}

}
