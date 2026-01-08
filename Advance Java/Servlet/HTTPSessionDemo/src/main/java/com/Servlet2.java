package com;

import jakarta.servlet.ServletException;
import java.io.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Servlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {

			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();

			HttpSession hs=request.getSession();

			String n=(String)hs.getAttribute("uname");
			pw.print("Hello "+n);
			pw.print(" Website Under Development, Coming Soon !! ");

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
