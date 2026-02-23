package com.vedant.gade.SpringJDBCDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/vedant/gade/SpringJDBCDemo/spring.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
        String sql = "insert into employee values(?,?,?)";
        int result = jdbcTemplate.update(sql,1,"Vedant","Gade");
        System.out.println("No of records inserted are : "+result);
    }
}
