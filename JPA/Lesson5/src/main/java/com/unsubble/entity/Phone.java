package com.unsubble.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Phone {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private String no;
	private String type;

	public Phone() {
		super();
	}

	public Phone(String no, String type) {
		super();
		this.no = no;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
