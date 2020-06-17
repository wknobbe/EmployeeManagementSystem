package com.business.ems.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="supervisors")
public class Supervisor extends Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="department_id")
	private Department department;
	@Size(min =2, max=20)
	private String title;
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	public Supervisor(@Size(min = 2, max = 30) String name, @Min(0) @Max(30) int yearsofservice,
			@Size(min = 2, max = 15) String role, Department deptSuperOf, @Size(min = 2, max = 20) String title) {
		super(name, yearsofservice, role);
		this.department = deptSuperOf;
		this.title = title;
	}
	public Department getDeptSuperOf() {
		return department;
	}
	public void setDeptSuperOf(Department deptSuperOf) {
		this.department = deptSuperOf;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
