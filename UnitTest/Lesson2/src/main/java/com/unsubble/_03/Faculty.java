package com.unsubble._03;

import java.util.Set;

import lombok.Data;

@Data
public class Faculty {
	private String code;
	private String name;
	private Set<Department> departments;
}
