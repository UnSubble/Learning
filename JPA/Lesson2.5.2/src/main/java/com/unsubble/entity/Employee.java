package com.unsubble.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name = "Employee_New_Name")
@Entity
public class Employee {
	
	@Id
	@Column(name = "emp_id")
	@GeneratedValue(strategy = GenerationType.AUTO) 
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
	
	@ManyToOne
	@JoinColumn(name = "dept_id") // normalde varsayılan ismi "PROPERTYNAME" + "_" + "IDNAME"
								  // @column kullanırsak hata verir.
	private Department department;
	
	@OneToOne
	@JoinColumn(name = "parking_id", unique = true) // JPA'ya göre unique durumu olmadan da kod hata vermeli
	private ParkingSpace parkingSpace;				// (eğer parkingSpace'leri aynıysa). Fakat eclipseLink
												// bu kurala uymaz. Mesela Hibernate JPA olsaydı hata verirdi.
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public ParkingSpace getParkingSpace() {
		return parkingSpace;
	}

	public void setParkingSpace(ParkingSpace parkingSpace) {
		this.parkingSpace = parkingSpace;
	}
	
	

}
