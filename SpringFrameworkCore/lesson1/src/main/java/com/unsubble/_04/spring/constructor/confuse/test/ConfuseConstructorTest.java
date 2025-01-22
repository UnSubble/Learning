package com.unsubble._04.spring.constructor.confuse.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.unsubble._04.spring.constructor.confuse.model.ConfuseConstructor;

public class ConfuseConstructorTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("constructorInjection.xml");
		ConfuseConstructor c = applicationContext.getBean("confuseId", ConfuseConstructor.class);
		System.out.println(c);
	}
}
