package com.unsubble._01.coupled.model;

public class Car {

	private Tire tire;
	
	public Car() {
		tire = new Tire();
	}
	
	public void go() {
		tire.useTire();
	}
}
