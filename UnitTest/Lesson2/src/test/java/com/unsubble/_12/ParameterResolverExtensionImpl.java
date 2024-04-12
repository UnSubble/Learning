package com.unsubble._12;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import com.unsubble._03.Student;

public class ParameterResolverExtensionImpl implements ParameterResolver {

	@Override
	public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
			throws ParameterResolutionException {
		return parameterContext.getParameter().getType() == Student.class && parameterContext.getIndex() == 0;
	}

	@Override
	public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
			throws ParameterResolutionException {
		if (parameterContext.getParameter().getType() == Student.class) {
			return new Student("1", "Ahmet", "asd");
		}
		return null;
	}

}
