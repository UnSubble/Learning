package com.unsubble._05;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doReturn;

import org.junit.Test;
import org.mockito.Mockito;

public class SpyTest {

	@Test
	public void testSpy() {
		CustomerService service = Mockito.spy(new CustomerService());
		doReturn("spy object called").when(service).getCustomerName(eq(new Customer("ali", 1)));
		System.out.println(service.getCustomerName(new Customer("ali", 1))); // gerçek obje çalışır ta ki
																			// when ve do kullanana dek
		System.out.println(service.getCustomerName(new Customer("ali", 2)));
	}
	
	@Test
	public void testSpy2() {
		CustomerService service = Mockito.spy(new CustomerService());
		doReturn("spy object called").when(service).getCustomerName(eq(new Customer("ali", 1))); // ali isimli
																	  // 1 idli geldiğinde "spy object called"
																	  // döndürecekti fakat aşağıdaki metot 
																	  // sayesinde gerçek obje çalışıyor.
		
		doCallRealMethod().when(service).getCustomerName(new Customer("ali", 1));
		System.out.println(service.getCustomerName(new Customer("ali", 1)));
	}
}
