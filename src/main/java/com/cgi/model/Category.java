package com.cgi.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCat;
	private String name;
	
	@OneToMany(mappedBy="category")
	private Collection<Idea> ideas;

	public Category(int idCat, String name, Collection<Idea> ideas) {
		super();
		this.idCat = idCat;
		this.name = name;
		this.ideas = ideas;
	}
	public Category(int idCat) {
		super();
		this.idCat = idCat;
	}

	public Category() {
		super();
	}
	
	

	public Category(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	@Override
	public String toString() {
		
		return getName();
	}
	

	public int getIdCat() {
		return idCat;
	}

	public void setIdCat(int idCat) {
		this.idCat = idCat;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Idea> getIdeas() {
		return ideas;
	}

	public void setIdeas(Collection<Idea> ideas) {
		this.ideas = ideas;
	}
	


}
