package com.unsubble._13;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(ExceptionHandlerImpl.class)
public class ExceptionHandlerTest {
	
	@Test
	public void test() {
		assertTrue(false);
	}

	@Test
	public void test2() {
		assertTrue(false);
	}
}
