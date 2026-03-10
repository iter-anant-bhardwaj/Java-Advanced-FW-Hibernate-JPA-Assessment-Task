package com.capgemini.java_dev.framework.hibernate_jpa.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Author implements Serializable {
	@Id
    private int id;

    private String name;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private Biography biography;
    

	public Author() {
	}


	public Author(int id, String name, String email, Biography biography) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.biography = biography;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Biography getBiography() {
		return biography;
	}


	public void setBiography(Biography biography) {
		this.biography = biography;
	}


	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", email=" + email + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(biography, email, id, name);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		return Objects.equals(biography, other.biography) && Objects.equals(email, other.email) && id == other.id
				&& Objects.equals(name, other.name);
	}

	
}
