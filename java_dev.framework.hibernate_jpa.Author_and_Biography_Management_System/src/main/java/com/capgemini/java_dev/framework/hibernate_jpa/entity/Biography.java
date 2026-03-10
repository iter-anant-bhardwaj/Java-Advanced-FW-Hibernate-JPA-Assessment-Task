package com.capgemini.java_dev.framework.hibernate_jpa.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Biography implements Serializable {
	@Id
    private int id;

    private String summary;
    private String birthPlace;
    private LocalDate birthDate;

    @OneToOne(mappedBy = "biography")
    private Author author;

	public Biography() {
	}

	public Biography(int id, String summary, String birthPlace, LocalDate birthDate) {
		this.id = id;
		this.summary = summary;
		this.birthPlace = birthPlace;
		this.birthDate = birthDate;
	}

	public int getId() {
		return id;
	}

	public String getSummary() {
		return summary;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public Author getAuthor() {
		return author;
	}
	

	public void setId(int id) {
		this.id = id;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Biography [id=" + id + ", summary=" + summary + ", birthPlace=" + birthPlace + ", birthDate="
				+ birthDate + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(birthDate, birthPlace, id, summary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Biography other = (Biography) obj;
		return Objects.equals(birthDate, other.birthDate) && Objects.equals(birthPlace, other.birthPlace)
				&& id == other.id && Objects.equals(summary, other.summary);
	}

	    
}
