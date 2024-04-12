package com.unsubble._03;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Semester {
	
	private int year;
	private Term term;

	public enum Term {
		FALL, SPRING, SUMMER
	}
	
	public Semester(LocalDate localDate) {
	}
}
