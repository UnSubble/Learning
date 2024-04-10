package com.unsubble._03;

import lombok.Data;

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
	
}
