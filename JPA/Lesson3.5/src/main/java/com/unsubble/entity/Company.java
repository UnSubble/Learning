package com.unsubble.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private String name;
	@Embedded
	@AttributeOverrides(value = { @AttributeOverride(name = "road", column = @Column(name = "avenue")),
			@AttributeOverride(name = "zip", column = @Column(name = "postal_code")) })
	// tek bir tane değiştireceksek @AttributeOverride'ı tekil olarak kullanabiliriz.
	private Address address;

	public Company() {
		super();
	}

	public Company(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
