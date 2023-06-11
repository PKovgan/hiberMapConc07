package com.pk.entities;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.pk.enums.EmployeeStatus;

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
	
	@Enumerated(EnumType.STRING)
	@Column(name = "work_status")
	private EmployeeStatus es;

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
	
	public Employee(String workId, String name, Manager manager, EmployeeStatus es) {
		this.workId = workId;
		this.name = name;
		this.manager = manager;
		this.es = es;
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
	
	public EmployeeStatus getEs() {
		return es;
	}

	public void setEs(EmployeeStatus es) {
		this.es = es;
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		return "Employee [id=" + id + ", workId=" + workId + ", name=" + name + ", manager=" + manager + ", projects="
				+ (projects != null ? toString(projects, maxLen) : null) + ", es=" + es + "]";
	}

	private String toString(Collection<?> collection, int maxLen) {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		int i = 0;
		for (Iterator<?> iterator = collection.iterator(); iterator.hasNext() && i < maxLen; i++) {
			if (i > 0)
				builder.append(", ");
			builder.append(iterator.next());
		}
		builder.append("]");
		return builder.toString();
	}
	
}
