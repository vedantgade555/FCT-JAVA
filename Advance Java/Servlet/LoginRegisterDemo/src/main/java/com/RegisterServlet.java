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

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String country = request.getParameter("country");

		try {
			Connection con = UserDao.getConnection();

			// 1️⃣ Check if user exists
			PreparedStatement ps =
			    con.prepareStatement("SELECT * FROM usertable WHERE id=?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				pw.println("User already exists <br>");
				pw.println("<a href='register.html'>Try Again</a>");
			} else {
				// 2️⃣ Insert new user
				PreparedStatement ps1 = con.prepareStatement(
				    "INSERT INTO usertable (id,name,password,email,country) VALUES (?,?,?,?,?)"
				);

				ps1.setInt(1, id);
				ps1.setString(2, name);
				ps1.setString(3, password);
				ps1.setString(4, email);
				ps1.setString(5, country);

				ps1.executeUpdate();

				pw.println("Registration successful! <br>");
				pw.println("<a href='login.html'>Login</a>");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
