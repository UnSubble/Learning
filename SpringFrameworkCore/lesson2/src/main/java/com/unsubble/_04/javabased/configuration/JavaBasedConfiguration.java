package com.unsubble._04.javabased.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.unsubble._04.javabased.model.Employee;


@Configuration // -> böylece bu class, spring için config classı oldu.
@PropertySource(value = "classpath:employee.properties")
@ComponentScan(basePackages = "com.unsubble._04.javabased.model") // -> context:component-scan tag'ine karşılık gelir.
@ImportResource // -> ek config xml için kullanılır.
public class JavaBasedConfiguration {
	
	@Autowired
	private Environment env;

	@Bean // -> xml'deki <bean> </bean>
	public Employee createEmployee() {
		Employee e = new Employee();
		e.setName(env.getProperty("empname"));
		e.setSurname(env.getProperty("empsurname"));
		return e;
	}
}
