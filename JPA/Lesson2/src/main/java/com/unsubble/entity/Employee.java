package com.unsubble.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name = "Employee_New_Name")
@Entity
public class Employee {
	
	@Id
	@Column(name = "emp_id")
	// @TableGenerator(name = "EMP_GEN") // örnek (a)
	// @GeneratedValue(generator = "EMP_GEN") // örnek (a)
	// @GeneratedValue(strategy = GenerationType.AUTO) // örnek (b)
	// @TableGenerator(name = "EMP_GEN_DETAILED", table = "KEY_GEN", pkColumnName = "ID_NAME", 
	//										valueColumnName = "COUNT", initialValue = 1000) // örnek (c)
	// @SequenceGenerator(name = "SEQ_GEN", sequenceName = "ilgili veri tabanındaki 
	//																	sequence objesinin adı") // örnek (d)
	// @GeneratedValue(generator = "SEQ_GEN") // örnek (d)
	private int id;
	
	@Column(name = "emp_name")
	private String name;
	
	@Column(name = "emp_surname")
	private String surname;
	
	@Column(name = "emp_salary")
	private int salary;
	
	@Column(name = "emp_type")
	@Enumerated(EnumType.STRING)
	private EmployeeType employeeType;
	
	@Column(name = "emp_date")
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Column(name = "emp_image")
	@Lob
	private byte[] image;
	
	public Employee() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public EmployeeType getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
	

}
