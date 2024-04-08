package com.unsubble._05;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

import java.util.List;

import org.assertj.core.api.Condition;
import org.junit.Test;

import lombok.AllArgsConstructor;
import lombok.Data;

public class AssertJTest {
	List<String> cities = List.of("Balıkesir","İzmir","Manisa");
	List<String> foreingCities = List.of("Amsterdam","New York","Berlin");
	
	
	@Test
	public void testStrings() {
		String text1 = "test";
		
		assertThat(text1).isEqualTo("test").startsWith("te").endsWith("st").isNotEmpty().isNotNull()
			.contains("es").doesNotContain("a")
			.describedAs("bu bir hata"); // hata mesajı için bu metodu kullanıyoruz.
	}
	
	@Test
	public void testList() {
		assertThat(cities).contains("Balıkesir").doesNotContain("Bursa")
		.containsExactly("Balıkesir","İzmir","Manisa").doesNotHaveDuplicates()
		.describedAs("Test failed");
	}
	
	@Test
	public void testLists() {
		List<String> cities = List.of("Balıkesir","İzmir");
		assertThat(cities).have(isKnownCities());
	}
	
	private Condition<? super String> isKnownCities() {
		return new Condition<String>() {

			@Override
			public boolean matches(String value) {
				return cities.contains(value);
			}
			
		};
	}
	
	@Test
	public void testComplex() {
		List<Item> items = List.of(new Item("john", 1), new Item("jennifer", 2), new Item("jennifer", 3));
		
		assertThat(items).extracting("name").contains("john","jennifer");
		assertThat(items).extracting("name", "id").contains(tuple("jennifer",2), tuple("jennifer",3));
	}
	
	@Data
	@AllArgsConstructor
	private static class Item {
		private String name;
		private int id;
	}
}
