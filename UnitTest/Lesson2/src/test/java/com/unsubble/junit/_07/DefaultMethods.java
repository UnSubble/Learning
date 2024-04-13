package com.unsubble.junit._07;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public interface DefaultMethods<T> {
	T createDomain();
	
	@Test 
	default void createDomainShouldBeImplemented() {
		assertNotNull(createDomain());
	}
}