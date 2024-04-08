package com.unsubble._04;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class HamcrestTest {
	
	@SuppressWarnings("deprecation")
	@Test
	public void testBasicEquations() {
		String text1 = "test";
		String text2 = "test2";
		
		assertEquals("test", text1);
		assertThat(text1, is(equalTo("test"))); // is metodu sadece okumayı kolaylaştırmak için
		assertThat(text1, is(notNullValue()));
		assertThat(text2, is(containsString("es")));
		assertThat(text2, is(anyOf(containsString("a"), containsString("b"), containsString("e"))));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testLists() {
		List<String> cities = List.of("Balıkesir","İzmir","Manisa");
		
		assertThat(cities, hasItem("Balıkesir"));
		assertThat(cities, allOf(hasItems("Balıkesir", "İzmir"), not("Bursa")));
	}
}
