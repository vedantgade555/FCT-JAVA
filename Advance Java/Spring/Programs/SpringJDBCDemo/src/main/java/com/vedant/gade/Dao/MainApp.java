package com.vedant.gade.Dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class MainApp {

	public static void main(String[] args) {
		  ApplicationContext context = new ClassPathXmlApplicationContext("com/vedant/gade/Dao/spring.xml");
	        StudentDao dao = (StudentDao) context.getBean("studentdao");
	        
	        dao.save(new Student("Vedant","vedant@555"));
	        List<Student> students = dao.findAll();
	        for(Student s:students) {
	        	System.out.println(s.getId()+" "+s.getName()+" "+s.getEmail());
	        }
	        
	        dao.delete(1);
	}

}
