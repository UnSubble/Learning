package com.unsubble._03;

import java.util.Set;

import lombok.Data;

@Data
public class Department {
	
	private String code;
	private String name;
	private Set<Lecturer> lecturers;
	private Set<Course> courses;
	private Set<Student> students;
	private Faculty faculty;
}
