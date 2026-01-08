package com;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import java.io.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletOne")
public class ServletOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ServletOne() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();		
			
			String uname = request.getParameter("username");
			String upass = request.getParameter("upass");
			
			if(upass.equals("abc@123"))
			{
				RequestDispatcher rd = request.getRequestDispatcher("ServletTwo");
				rd.forward(request, response);
			}
			else
			{
				pw.print("Sorry Incorrect Password");
				RequestDispatcher rd = request.getRequestDispatcher("/index.html");
				rd.include(request, response);
				
			}
			
		}catch(Exception e){
			System.out.println(e);
		}
	}

}
