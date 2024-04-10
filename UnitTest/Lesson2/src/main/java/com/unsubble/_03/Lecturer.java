package com.unsubble._03;

import java.util.Set;

import lombok.Data;

@Data
public class Lecturer {

	private String id;
	private String name;
	private String surname;
	private String title;
	private Set<LecturerCourseRecord> lecturerCourseRecords;
	private Department department;
	
}
