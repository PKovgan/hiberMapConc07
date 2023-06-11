package com.pk.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Manager {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	@Column(name="manager_id", nullable=false)
	private String managerId;
	private String name;
	private Integer salary;
	@OneToMany(mappedBy="manager",cascade = {CascadeType.PERSIST})
	private Set<Employee> employees = new HashSet<Employee>();
	
	@ElementCollection
	@CollectionTable(name = "manager_projects", joinColumns=@JoinColumn(name = "manager_id"))
	@Column(name = "project_ids")
	private List<String> projectIDs = new ArrayList<String>();
	
	public Manager() {
	}
	public Manager(String managerId, String name, Integer salary) {
		this.managerId = managerId;
		this.name = name;
		this.salary = salary;
	}
	
	public Manager(String managerId, String name, Integer salary, Set<Employee> employees) {
		this.managerId = managerId;
		this.name = name;
		this.salary = salary;
		this.employees = employees;
	}
	
	public Manager(String managerId, String name, Integer salary, Set<Employee> employees, List<String> projectIDs) {
		this.managerId = managerId;
		this.name = name;
		this.salary = salary;
		this.employees = employees;
		this.projectIDs = projectIDs;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
	public void addEmployee(Employee employee) {
		employees.add(employee);
		employee.setManager(this);
	}
	public List<String> getProjectIDs() {
		return projectIDs;
	}
	public void setProjectIDs(List<String> projectIDs) {
		this.projectIDs = projectIDs;
	}
	@Override
	public String toString() {
		final int maxLen = 10;
		return "Manager [id=" + id + ", managerId=" + managerId + ", name=" + name + ", salary=" + salary
				+ ", projectIDs="
				+ (projectIDs != null ? projectIDs.subList(0, Math.min(projectIDs.size(), maxLen)) : null) + "]";
	}
	
}
