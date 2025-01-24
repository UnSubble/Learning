package com.unsubble._01.aop.service;

import org.springframework.aop.framework.ProxyFactory;

public class TestThrows {

	public static void main(String[] args) {
		LoggerWriter writer = new LoggerWriter();
		ProxyFactory factory = new ProxyFactory();
		factory.addAdvice(new MethodThrowsAdviceImpl());
		factory.setTarget(writer);
		
		LoggerWriter proxyObj = (LoggerWriter)factory.getProxy();
		try {
			proxyObj.logThrows();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
