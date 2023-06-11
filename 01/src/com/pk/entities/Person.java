package com.pk.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class Person {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Column(name = "id")
	private Long id;
	@Column(nullable=false/*, name = "name" */)
	private String name;
	@Embedded
//	@AttributeOverrides({
//		@AttributeOverride(name = "street", column = @Column(name = "new_name")),
//		@AttributeOverride(name = "city", column = @Column(name = "any_name")),
//		@AttributeOverride(name = "zipcode", column = @Column(name = "some_name"))
//	})
	private Address address;
	public Person() {
	}
	public Person(String name, Address address) {
		this.name = name;
		this.address = address;
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	
}
