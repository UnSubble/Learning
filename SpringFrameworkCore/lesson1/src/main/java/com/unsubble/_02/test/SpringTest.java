package com.unsubble._02.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.unsubble._02.model.Car;

public class SpringTest {
	public static void main(String[] args) {
		
		 @SuppressWarnings("resource")
		 ApplicationContext applicationContext = new ClassPathXmlApplicationContext("appcontext.xml");
		 Car car = applicationContext.getBean("carId", Car.class);
		 car.go();
	}
}
