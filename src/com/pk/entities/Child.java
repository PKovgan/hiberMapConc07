package com.pk.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Entity
public class Child {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String name;
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "firstname_fk", referencedColumnName = "fistField"),
		@JoinColumn(name = "secondname_fk", referencedColumnName = "secondField"),
	})
	private Parent parent;
	public Child() {
	}
	public Child(String name, Parent parent) {
		this.name = name;
		this.parent = parent;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Parent getParent() {
		return parent;
	}
	public void setParent(Parent parent) {
		this.parent = parent;
	}
}
