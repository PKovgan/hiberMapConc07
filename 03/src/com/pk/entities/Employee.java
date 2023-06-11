package com.pk.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name="work_id", nullable=false)
	private String workId;
	
	private String name;
	
//	@Cascade({CascadeType.PERSIST, CascadeType.DELETE})
	@ManyToOne(cascade= {javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REMOVE})
//	@ManyToOne
	@JoinColumn(name ="manager_id")
	private Manager manager;

	public Employee() {
	}

	public Employee(String workId, String name, Manager manager) {
		this.workId = workId;
		this.name = name;
		this.manager = manager;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWorkId() {
		return workId;
	}

	public void setWorkId(String workId) {
		this.workId = workId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
}
