package com.config.annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("com/config/annotations/spring.xml");

        Instructor instructor = context.getBean("inst", Instructor.class);

        System.out.println(instructor);
        System.out.println(instructor.hashCode());
    }
}