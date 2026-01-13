package com;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet Filter implementation class MyFilter
 */
@WebFilter("/MyFilter")
public class MyFilterOne extends HttpFilter implements Filter {

    public MyFilterOne() {
        super();
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
    	response.setContentType("text/html");

        PrintWriter pw = response.getWriter();

        String password = request.getParameter("password");

        if (password.equals("Admin")) {
            chain.doFilter(request, response);
        } else {
            pw.print("Incorrect Password");
            RequestDispatcher rd = request.getRequestDispatcher("index.html");
            rd.include(request, response);
//            rd.forward(request, response);
        }
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }
}
