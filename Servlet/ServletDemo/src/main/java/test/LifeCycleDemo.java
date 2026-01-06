package test;

import jakarta.servlet.ServletConfig;
import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class LifeCycleDemo
 */
@WebServlet("/LifeCycleDemo")
public class LifeCycleDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	String msg;
    public LifeCycleDemo() {
        super();
       
    }

	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init method executed");
		msg="Welcome";
	}

	
	public void destroy() {
		System.out.println("destroy method executed");
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html");
//		PrintWriter pw = response.getWriter();
//		pw.println("<html><body>");
//		pw.println(msg+" Service method Executed");
//		pw.println("</body></html>");
//		pw.close();
		
		
		if(request.getMethod().equalsIgnoreCase("GET"))
		{
			doGet(request,response);
		}
		else if(request.getMethod().equalsIgnoreCase("POST"))
		{
			doPost(request,response);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.getWriter().println("Response Handle by doGet()");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.getWriter().println("Request Handle by doPost()");
	}

}
