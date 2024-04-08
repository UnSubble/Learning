package com.unsubble._02;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ExceptionTest {
	
	private Exceptions exceptions;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setup() {
		exceptions = new Exceptions();
	}
	
	@Test(expected = RuntimeException.class)
	public void testRuntime() {
		exceptions.runtime();
	}
	
	@Test
	public void testRuntime2() {
		thrown.expect(RuntimeException.class);
		
		exceptions.runtime();
	}
}
