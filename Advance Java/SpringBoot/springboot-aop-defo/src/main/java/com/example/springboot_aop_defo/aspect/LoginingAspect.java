package com.example.springboot_aop_defo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoginingAspect {
	
	@Before("execution.(*.com.example.springboot_aop_defo.service.*.*.(..))")
	public void beforeMethos(JoinPoint joinPoint) {
		System.out.println("Before Execution of Method");
	}
	
	@After("execution.(*.com.example.springboot_aop_defo.service.*.*.(..))")
	public void afterMethod(JoinPoint joinPoint) {
		System.out.println("After execution of method");
	}
}
