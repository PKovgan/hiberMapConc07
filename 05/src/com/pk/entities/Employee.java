package com.pk.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name="work_id", nullable=false)
	private String workId;
	
	private String name;
	
	@ManyToOne(cascade= {javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REMOVE})
	@JoinColumn(name ="manager_id")
	private Manager manager;
	
	@ManyToMany(mappedBy = "employees")
	private Set<Project> projects = new HashSet<Project>();

	public Employee() {
	}

	public Employee(String workId, String name, Manager manager) {
		this.workId = workId;
		this.name = name;
		this.manager = manager;
	}
	
	public Employee(String workId, String name, Manager manager, Set<Project> projects) {
		this.workId = workId;
		this.name = name;
		this.manager = manager;
		this.projects = projects;
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
	
	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", workId=" + workId + ", name=" + name + ", manager=" + manager + "]";
	}
	
	
	
}
