package com.pk.entities;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String name;
	private String projectId;
	@ManyToMany(cascade = {CascadeType.PERSIST})
	@JoinTable(name = "project_employee",
				joinColumns = {@JoinColumn(name="projectNAME")},
				inverseJoinColumns = {@JoinColumn(name="employeeNAME")})
	private Set<Employee> employees = new HashSet<Employee>();
	public Project() {
	}
	public Project(String name, String projectId, Set<Employee> employees) {
		this.name = name;
		this.projectId = projectId;
		this.employees = employees;
	}
	public Project(String name, String projectId) {
		this.name = name;
		this.projectId = projectId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	@Override
	public String toString() {
		return "Project [name=" + name + ", projectId=" + projectId + "]";
	}
	
}
