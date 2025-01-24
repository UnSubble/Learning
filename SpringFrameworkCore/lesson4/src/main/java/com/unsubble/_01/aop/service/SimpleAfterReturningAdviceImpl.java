package com.unsubble._01.aop.service;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class SimpleAfterReturningAdviceImpl implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("After method: " + method);
		System.out.println("Return value: " + returnValue);
	}

}
