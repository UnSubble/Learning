package com.unsubble._02.aspectj.service;

public class AuditServiceAspect {

	public void logBefore() {
		System.out.println("before saving...");
	}
}
