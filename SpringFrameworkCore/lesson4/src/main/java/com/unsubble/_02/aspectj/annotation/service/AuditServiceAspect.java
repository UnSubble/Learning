package com.unsubble._02.aspectj.annotation.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Aspect
@EnableAspectJAutoProxy
public class AuditServiceAspect {

	@Before("execution(* com.unsubble._02.aspectj.annotation.service.EmployeeService.saveEmployee(..))")
	public void logBefore() {
		System.out.println("before saving...");
	}
}
