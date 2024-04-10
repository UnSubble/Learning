package com.unsubble._03;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentCourseRecord {

	private final LecturerCourseRecord lecturerCourseRecord;
	private Grade grade;
	private CourseReview courseReview;
	private Student student;
	
	public enum Grade {
		A1, A2, B1, B2, C, D, E, F
	}
	
}
