package com.pk.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class InsurenceCode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String insurenceCode;
	@OneToOne(mappedBy = "ic")
	private Person person;
	public InsurenceCode() {}
	public InsurenceCode(String insurenceCode, Person person) {
		this.insurenceCode = insurenceCode;
		this.person = person;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getInsurenceCode() {
		return insurenceCode;
	}
	public void setInsurenceCode(String insurenceCode) {
		this.insurenceCode = insurenceCode;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
}
