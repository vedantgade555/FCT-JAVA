package com.vedant.gade.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginAspect {
	@Before("execution(*  com.vedant.gade.service.*.*(..))")
	public void logBefore() {
		System.out.println("Login Before method Execution ");
	}
	
	@After("execution(*  com.vedant.gade.service.*.*(..))")
	public void lofAfter() {
		System.out.println("After Payment Process   ");
	}

}
