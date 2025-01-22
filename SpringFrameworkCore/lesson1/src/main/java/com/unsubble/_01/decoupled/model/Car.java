package com.unsubble._01.decoupled.model;

public class Car implements Vehicle {
	
	private Wheel wheel;

	@Override
	public void setWheel(Wheel wheel) {
		this.wheel = wheel;
	}

	@Override
	public void go() {
		wheel.useTire();
	}

}
