package com.unsubble._07;

import com.unsubble._03.Student;

public class DefaultMethodsImpl implements DefaultMethods<Student> {

	@Override
	public Student createDomain() {
		return new Student("1", "Ahmet", "Can");
	}

	
}
