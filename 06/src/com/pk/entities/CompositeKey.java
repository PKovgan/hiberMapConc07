package com.pk.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CompositeKey implements Serializable{
	
	private static final long serialVersionUID = -7773052037409192166L;
	private String fistField;
	private String secondField;
	public CompositeKey(String fistField, String secondField) {
		this.fistField = fistField;
		this.secondField = secondField;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fistField == null) ? 0 : fistField.hashCode());
		result = prime * result + ((secondField == null) ? 0 : secondField.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompositeKey other = (CompositeKey) obj;
		if (fistField == null) {
			if (other.fistField != null)
				return false;
		} else if (!fistField.equals(other.fistField))
			return false;
		if (secondField == null) {
			if (other.secondField != null)
				return false;
		} else if (!secondField.equals(other.secondField))
			return false;
		return true;
	}
	
	

}
