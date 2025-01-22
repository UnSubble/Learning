package com.unsubble._03.dependency.injection;

public class SetterInjection {
	
	private Dependency dependency;
	
	public void setDependency(Dependency dependency) {
		this.dependency = dependency;
	}
	
	public Dependency getDependency() {
		return dependency;
	}
}
