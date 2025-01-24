package com.unsubble._01.aop.service;

import org.springframework.aop.framework.ProxyFactory;

public class TestAfter {

	public static void main(String[] args) {
		LoggerWriter writer = new LoggerWriter();
		ProxyFactory factory = new ProxyFactory();
		factory.addAdvice(new SimpleAfterReturningAdviceImpl());
		factory.setTarget(writer);
		
		LoggerWriter logger = (LoggerWriter)factory.getProxy();
		logger.log("test");
	}

}
