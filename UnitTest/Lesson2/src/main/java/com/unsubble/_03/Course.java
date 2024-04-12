package com.unsubble._03;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class Course {
	
	private String code;
	private String name;
	private String description;
	private CourseType courseType;
	private int credit;
	private Department department;
	
	public enum CourseType {
		MANDATORY,
		ELECTIVE
	}
	
	public Course(String name) {
		this.name = name;
	}
	
}
