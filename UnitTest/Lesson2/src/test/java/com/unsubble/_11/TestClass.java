package com.unsubble._11;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.unsubble._03.Student;

@ExtendWith(TestInstanceProProccessorImpl.class)
public class TestClass {
	
	Student ahmet;

	@Test
	public void test() {
		assertEquals("Ahmet", ahmet.getName());
	}

	@Test
	public void test2() {
		assertEquals("Ahmet", ahmet.getName());
	}
}
