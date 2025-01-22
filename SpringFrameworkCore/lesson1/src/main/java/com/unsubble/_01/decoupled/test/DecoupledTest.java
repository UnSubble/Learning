package com.unsubble._01.decoupled.test;

import com.unsubble._01.decoupled.model.Car;
import com.unsubble._01.decoupled.model.Lassa;
import com.unsubble._01.decoupled.model.Vehicle;
import com.unsubble._01.decoupled.model.Wheel;

public class DecoupledTest {
	public static void main(String[] args) {
		Vehicle car = new Car();
		
		Wheel lassa = new Lassa();
		
		car.setWheel(lassa);
		
		car.go();
	}
}
