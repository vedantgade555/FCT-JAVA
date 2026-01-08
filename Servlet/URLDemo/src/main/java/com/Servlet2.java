package com;
import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Servlet2() {
        super();
        // TODO Auto-generated constructor stub
        
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  try {
				response.setContentType("text/html");
				
				PrintWriter pw = response.getWriter();
				String s = request.getParameter("utest");
				pw.print("Hello "+s);
				
				pw.print("This Site is under Construction");
				
				pw.close();
				
			}catch(Exception e) {
				System.out.println(e);
			}
	}

}
