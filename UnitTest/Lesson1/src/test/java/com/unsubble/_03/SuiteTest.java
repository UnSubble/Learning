package com.unsubble._03;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.unsubble._01.CalculatorTest;
import com.unsubble._01.ParameterTest;
import com.unsubble._01.ParameterTest2;

@RunWith(Suite.class)
@SuiteClasses({
	CalculatorTest.class,
	ParameterTest.class,
	ParameterTest2.class
})
public class SuiteTest {

}
