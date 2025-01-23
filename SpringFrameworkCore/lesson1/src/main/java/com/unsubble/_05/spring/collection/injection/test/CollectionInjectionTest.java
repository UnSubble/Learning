package com.unsubble._05.spring.collection.injection.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.unsubble._05.spring.collection.injection.model.CollectionInjection;

public class CollectionInjectionTest {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("collectionInjection.xml");
		CollectionInjection c = applicationContext.getBean("collectionId", CollectionInjection.class);
		System.out.println(c);
	}
}
