package com.unsubble._01.aop.service;

import org.springframework.aop.framework.ProxyFactory;

public class TestAround {
	
	public static void main(String[] args) {
		LoggerWriter writer = new LoggerWriter();
		ProxyFactory factory = new ProxyFactory();
		factory.addAdvice(new AroundAdviceImpl());
		factory.setTarget(writer);
		
		LoggerWriter proxyObj = (LoggerWriter)factory.getProxy();
		proxyObj.log();
		
	}
}
