package com.unsubble.junit._10;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

public class TestExtension implements ExecutionCondition {

	@Override
	public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
		
		if (context.getTags().contains("1.")) {
			return ConditionEvaluationResult.enabled("1. tagli test olduğundan çalışır.");
		}
		
		return ConditionEvaluationResult.disabled("Sadece belirli testler çalışır.");
	}

}
