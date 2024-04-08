package com.unsubble._01;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class CalculatorTest {
	Calculator calculator;
	
	@BeforeClass
	public static void behavioralSetUp() {
		// class'ın oluşmasından da önce bu metot çağırılır
	}
	
	@Before
	public void setUp() {
		calculator = new Calculator();
	}

	@Test
	public void testSum() {
		// Calculator calculator = new Calculator(); // ortak kullanılan field'ları setup altında 
													// toplayabilirsin.
		int a = 4;
		int b = 5;
		
		int result = calculator.sum(a, b);
		assertEquals(a + b, result); // eşit değilse hata fırlatır
	}
	
	@Test
	public void testNotEquals() {
		int a = 4;
		int b = 5;
		
		int result = calculator.sum(a, b);
		assertNotEquals(1, result); // eşitse hata fırlatır
	}
	
	@Test
	public void testNotNull() {
		assertNotNull(calculator); // nullsa hata fırlatır
	}
	
	@Test
	public void testNull() {
		assertNull(null); // null değilse hata fırlatır
	}
	
	@Test
	public void testSame() {
		assertSame(calculator, calculator); // nesneler aynı değilse hata fırlatır	
	}	
	
	@Ignore // testi çalıştırmaz.
	@Test
	public void testArrayEquals() {
		assertArrayEquals(new int[] {1,2}, new int[] {1,2}); // array'ler aynı değilse hata fırlatır
	}
	
	@Test
	public void testThrows() {
		assertThrows(RuntimeException.class, () -> { throw new RuntimeException(); });
		// hatalar aynı değilse hata fırlatır
	}
	
	@After
	public void terminate() {
		calculator = null;
	}
	
	@AfterClass
	public static void shutdown() {
		System.out.println("shutting down..."); // class'ın bütün işleri bittikten sonra bu metot 
												// çağırılır.
	}
}
