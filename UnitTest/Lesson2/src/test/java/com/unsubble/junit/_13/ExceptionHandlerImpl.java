package com.unsubble.junit._13;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

public class ExceptionHandlerImpl implements TestExecutionExceptionHandler {

	@Override
	public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
		System.out.println(String.format("%s %s", context.getRequiredTestMethod().getName(), 
				throwable.getMessage()));
		throw throwable;
	}

}
