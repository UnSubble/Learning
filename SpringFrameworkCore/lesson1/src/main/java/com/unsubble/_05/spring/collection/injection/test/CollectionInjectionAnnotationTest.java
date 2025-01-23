package com.unsubble._05.spring.collection.injection.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.unsubble._05.spring.collection.injection.model.CollectionInjectionAnnotation;

public class CollectionInjectionAnnotationTest {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("collectionInjectionAnnotation.xml");
		CollectionInjectionAnnotation c = applicationContext.getBean("collectionInjectionAnnotation",
				CollectionInjectionAnnotation.class);
		System.out.println(c);
	}
}
