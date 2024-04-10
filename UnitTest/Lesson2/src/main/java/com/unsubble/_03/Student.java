package com.unsubble._03;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Student {

	private final String id;
	private final String name;
	private final String surname;
	private Set<StudentCourseRecord> studentCourseRecords = new HashSet<>();
	private Department department;
	
}
