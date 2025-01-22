package com.unsubble._04.spring.constructor.confuse.model;

public class ConfuseConstructor {
	private String name;
	private int age;

	public ConfuseConstructor(int age) {
		super();
		this.age = age;
	}

	public ConfuseConstructor(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "ConfuseConstructor [name=" + name + ", age=" + age + "]";
	}

}
