package com.unsubble._11;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;

import com.unsubble._03.Student;

public class TestInstanceProProccessorImpl implements TestInstancePostProcessor {

	@Override
	public void postProcessTestInstance(Object testInstance, ExtensionContext context) throws Exception {
		final TestClass testClass = (TestClass) testInstance;
		
		testClass.ahmet = new Student("1", "Ahmet", "asd");
	}

}
