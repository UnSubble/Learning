package com.unsubble._05;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MockitoAnnotationTest {
	
	@Mock
	private CustomerService customerService;
	
	@Test
	public void testAnnotation() {
		customerService.saveCustomer(new Customer("ali", 1));
	}
}
