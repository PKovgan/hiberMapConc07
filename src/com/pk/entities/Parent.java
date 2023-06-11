package com.pk.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Parent {
	@EmbeddedId
	private CompositeKey ck;
	
	@OneToMany(mappedBy = "parent", cascade = {CascadeType.PERSIST})
	private Set<Child> children = new HashSet<Child>();

	public Parent() {
	}

	public Parent(CompositeKey ck) {
		this.ck = ck;
	}

	public Set<Child> getChildren() {
		return children;
	}

	public void setChildren(Set<Child> children) {
		this.children = children;
	}
	public void addChild(Child child) {
		child.setParent(this);
		this.children.add(child);
	}
}
