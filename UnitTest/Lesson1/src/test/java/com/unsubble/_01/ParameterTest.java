package com.unsubble._01;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterTest {
	private Calculator calculator;
	
	private int a;
	private int b;
	private int result;
	
	public ParameterTest(int a, int b, int result) {
		this.a = a;
		this.b = b;
		this.result = result;
	}
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {{2,5,7}, {4,8,12}, {3,4,7}});
	}
	
	@Before
	public void setUp() {
		calculator = new Calculator();
	}
	
	@Test
	public void testSum() {
		assertEquals(result, calculator.sum(a, b));
	}
}
