package com.business.ems.models;

import java.util.Date;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min = 2, max = 30)
	private String name;
	@Min(0)
	@Max(30)
	private int yearsofservice;
	private String employeeid = setEmployeeid();
	@Size(min = 2, max = 20)
	private String role;
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="department_id")
	private Department department;
	
	public Employee() {}
	
	public Employee(String name, int yearsofservice, String role) {
		this.name = name;
		this.yearsofservice = yearsofservice;
		this.role = role;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYearsofservice() {
		return yearsofservice;
	}
	public void setYearsofservice(int yearsofservice) {
		this.yearsofservice = yearsofservice;
	}
	
	public String getEmployeeid() {
		return employeeid;
	}
	public String setEmployeeid() {
		String options = "0123456789";
		Random r = new Random();
		String id = "";
		for (int i = 0; i < 6; i++) {
			id += options.charAt(r.nextInt(10));
		}
		return id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	
}
