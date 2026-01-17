package com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String password = request.getParameter("password");
		
		try {
			PrintWriter pw = response.getWriter();
			Connection con = UserDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from usertable where id=? and password=?");
			
			ps.setInt(1, id);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				pw.print("<h2>Welcone "+rs.getString("name")+"</h2>");
			}
			else {
				pw.println("<p>Invalid Username or Password </p>");
				pw.println("<a href='login.html'>Login Again</a>");

			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
