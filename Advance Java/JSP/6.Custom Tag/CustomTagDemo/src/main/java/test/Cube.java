package test;

import java.io.IOException;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

public class Cube extends SimpleTagSupport{
	private int num;
	public void setNum(int num) {
		this.num=num;
	}
	
	public void doTag() throws JspException,IOException{
		JspWriter jw = getJspContext().getOut();
		jw.println("Cube is  "+num*num*num); 
	}
}
