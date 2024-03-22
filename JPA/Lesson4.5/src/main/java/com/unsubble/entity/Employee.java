package com.unsubble.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name = "Employee_New_Name")
@Entity
// @NamedQuery(name = "Employee.findAllEmployees", query = "SELECT e from Employee e") 
// namedquery sorgularımız için. (NamedQuery isimleri unique olmak zorunda.)
// birden fazla sorgu için @NamedQueries
@NamedQueries({@NamedQuery(name = "Employee.findAllEmployees", query = "SELECT e from Employee e"),
	@NamedQuery(name = "Employee.findById", query = "Select e from Employee e where e.id = :id")})
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
	@JoinColumn(name = "dept_id")
	private Department department;

	@OneToOne
	@JoinColumn(name = "parking_id", unique = true)
	private ParkingSpace parkingSpace;

	@OneToMany
	@JoinTable(name = "emp_phone", joinColumns = { @JoinColumn(name = "emp_id") }, inverseJoinColumns = {
			@JoinColumn(name = "phone_id") })
	private List<Phone> phone;

	@ManyToMany
	private List<Project> projects;

	public List<Phone> getPhone() {
		return phone;
	}

	public void setPhone(List<Phone> phone) {
		this.phone = phone;
	}

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

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

}
