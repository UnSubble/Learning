package com.unsubble._05;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LombokTest {
	
	@Test
	public void testLombok() {
		Customer customer = new Customer("test",1);
		assertEquals("test", customer.getName());
	}
}
