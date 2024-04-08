package com.unsubble._05;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

public class MockitoTest {

	@Test
	public void testBehavior() {
		CustomerService service = Mockito.mock(CustomerService.class);

		service.saveCustomer(new Customer("ali", 1));
		service.saveCustomer(new Customer("veli", 2));

		Mockito.verify(service).saveCustomer(new Customer("ali", 1));
		Mockito.verify(service).saveCustomer(new Customer("veli", 2));
	}

	@Test
	public void testHowManyTimesCalled() {
		CustomerService service = Mockito.mock(CustomerService.class);

		service.saveCustomer(new Customer("ali", 1));
		service.saveCustomer(new Customer("ali", 1));
		service.saveCustomer(new Customer("veli", 2));
		
		Mockito.verify(service, times(2)).saveCustomer(new Customer("ali", 1));
		Mockito.verify(service, times(1)).saveCustomer(new Customer("veli", 2));
		
		Mockito.verify(service, never()).saveCustomer(new Customer("ahmet",3)); 
		Mockito.verify(service, never()).removeCustomer(any(Customer.class)); 
																// any() metotlu parametresi yerine herhangi 
																// bir şey verip vermememiz fark etmez.
		
		Mockito.verify(service, atLeast(2)).saveCustomer(new Customer("ali", 1)); // en az 2 defa kullanıldı mı
	}
	
	@Test
	public void testOrdery() {
		CustomerService service = Mockito.mock(CustomerService.class);

		service.saveCustomer(new Customer("ali", 1));
		service.removeCustomer(new Customer("ali", 1));
		service.saveCustomer(new Customer("veli", 2));
		
		InOrder inOrder = Mockito.inOrder(service);
		
		inOrder.verify(service).saveCustomer(new Customer("ali", 1));
		inOrder.verify(service).removeCustomer(new Customer("ali", 1));
		inOrder.verify(service).saveCustomer(new Customer("veli", 2));
	}
	
	@Test
	public void testNoMore() {
		CustomerService service = Mockito.mock(CustomerService.class);

		service.saveCustomer(new Customer("ali", 1));
		service.saveCustomer(new Customer("veli", 2));
		// service.saveCustomer(new Customer("ali", 1)); // THROWS AN EXCEPTION

		Mockito.verify(service).saveCustomer(new Customer("ali", 1));
		Mockito.verify(service).saveCustomer(new Customer("veli", 2));
		
		Mockito.verifyNoMoreInteractions(service); // artık bu objeye ait metotlar hiçbir şekilde çağrılmasın
											   // bu işlem ilk önce verify'larla çağırılan metot sayısının 
											   // eşitliğine bakar. Eğer eşit değillerse hata fırlatır. Eğer
											   // bunlar eşitse ve daha fazla bu objeye ait metot çağırılırsa
											   // hata fırlatır.
		
		// Mockito.verifyNoInteractions(service); // bu da hiç metot çağırılmamasını sağlar.
	}
	
	@Test
	public void testWhen() {
		CustomerService service = Mockito.mock(CustomerService.class);
		
		String name = service.getCustomerName(new Customer("ali", 1)); // her zaman null verir.
		
		assertThat(name).isEqualTo(null);
	}
	
	@Test
	public void testWhen2() {
		CustomerService service = Mockito.mock(CustomerService.class);
		when(service.getCustomerName(any(Customer.class))).thenReturn("ali");
		String name = service.getCustomerName(new Customer("ali", 1));
		
		assertThat(name).isEqualTo("ali");
	}
	
	@Test
	public void testWhen3() {
		CustomerService service = Mockito.mock(CustomerService.class);
		when(service.getCustomerName(eq(new Customer("ali", 1)))).thenReturn("ali"); // customer name ve id
																					// ali ve 1 olduğu zaman
																					// "ali" döner
		String name = service.getCustomerName(new Customer("ali", 1));
		
		assertThat(name).isEqualTo("ali");
	}
	
	@Test
	public void testWhen4() {
		CustomerService service = Mockito.mock(CustomerService.class);
		try {
			when(service.getCustomerName(any(Customer.class))).thenThrow(RuntimeException.class);
		} catch (RuntimeException e) {
			String name = service.getCustomerName(new Customer("ali", 1));
		
			assertThat(name).isEqualTo(null);
		}
	}
	
	@Test
	public void testWhen5() {
		CustomerService service = Mockito.mock(CustomerService.class);
		doNothing().when(service).saveCustomer(new Customer("ali", 1)); // saveCustomer çağırılınca hiçbir şey 
																		// yapma
	}
	
	@Test
	public void testWhen6() {
		CustomerService service = Mockito.mock(CustomerService.class);
		doReturn("ali").when(service).getCustomerName(new Customer("ali", 1)); // ali adlı 1 idli customer 
																		// objesi geldiği zaman "ali" dön
	}
}
