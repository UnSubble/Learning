package com.unsubble._01;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class ParameterTest2 {
	private Calculator calculator;
	
	@Before
	public void setUp() {
		calculator = new Calculator();
	}
	
	@Test
	@Parameters(value = {"10,2,12", "20,30,50"})
	public void testSum(int a, int b, int result) {
		assertEquals(result, calculator.sum(a, b));
	}
}
