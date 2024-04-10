package com.unsubble._03;

import java.util.Set;

import lombok.Data;

@Data
public class CourseReview {

	private Lecturer lecturer;
	private Set<Student> students;
	private Course course;
	
	
}
