package com.unsubble.junit._02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.unsubble._02.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Hesap makinesi testleri")
public class CalculatorTest {

	@DisplayName("Tam sayıların toplanması senaryosu") // test aşamasında isimleri böyle gözükür
	@Test
	public void testSum() {
		int a = 1;
		int b = 2;
		
		Calculator calculator = new Calculator();
		
		int result = calculator.sum(a, b);
		
		assertEquals(3, result);
	}
}
