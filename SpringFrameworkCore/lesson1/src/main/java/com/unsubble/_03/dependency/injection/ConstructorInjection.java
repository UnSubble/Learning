package com.unsubble._03.dependency.injection;

public class ConstructorInjection {

	private Dependency dependency;
	
	public ConstructorInjection(Dependency dependency) {
		this.dependency = dependency;
	}
}
