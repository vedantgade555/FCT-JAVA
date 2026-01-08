package com;

import jakarta.servlet.ServletException;
import java.io.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SecondServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			
			Cookie ck[] = request.getCookies();
			pw.print("Hello"+ck[0].getValue());
			
			pw.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
