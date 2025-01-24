package com.unsubble._01.aop.service;

public class LoggerWriter {

	public void log()  {
		System.out.println("LoggerWriter$log");
	}
	
	public boolean log(String msg) {
		System.out.println("LoggerWriter$log: " + msg);
		return true;
	}
	
	public void logThrows() {
		int x = 5 / 0;
		System.out.println("unreachable!");
	}
}
