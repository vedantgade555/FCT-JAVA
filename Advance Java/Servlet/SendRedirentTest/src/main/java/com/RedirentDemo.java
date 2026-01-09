package com;
import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RedirentDemo")
public class RedirentDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RedirentDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String s = request.getParameter("searchdata");
		
		response.sendRedirect("https://www.google.com/search?q="+s);
	
		pw.close();
	}

}
