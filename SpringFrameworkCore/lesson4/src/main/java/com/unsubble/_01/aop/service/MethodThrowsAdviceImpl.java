package com.unsubble._01.aop.service;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

public class MethodThrowsAdviceImpl implements ThrowsAdvice {

	public void afterThrowing(Exception ex) throws Throwable {
		System.out.println("Generic exception caught");
		System.out.println(ex.getClass().getName());
	}
	
	public void afterThrowing(Method method, Object[] args, Object Target, ArithmeticException ex) throws Throwable {
		System.out.println("ArithmeticException caught");
		System.out.println(ex.getClass().getName());
	}
	
	public void afterThrowing(Method method, Object[] args, Object Target, NumberFormatException ex) throws Throwable {
		System.out.println("NumberFormatException caught");
		System.out.println(ex.getClass().getName());
	}
}
