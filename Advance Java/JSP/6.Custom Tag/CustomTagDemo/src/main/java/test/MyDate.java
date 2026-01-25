package test;

import java.io.IOException;
import java.util.Calendar;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

public class MyDate extends SimpleTagSupport{
	
	public void doTag() throws JspException,IOException{
		JspWriter jw = getJspContext().getOut();
		jw.println(Calendar.getInstance().getTime()); 
	}
}
