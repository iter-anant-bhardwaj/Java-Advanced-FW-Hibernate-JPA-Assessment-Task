package com.capgemini.java_dev.framework.hibernate_jpa.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Address implements Serializable {
	@Id
    private int id;
    private String street;
    private String city;
    private String zipcode;

    @OneToOne(mappedBy = "address")
    private Employee employee;

	public Address() {
	}

	public Address(int id, String street, String city, String zipcode, Employee employee) {
		this.id = id;
		this.street = street;
		this.city = city;
		this.zipcode = zipcode;
		this.employee = employee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", city=" + city + ", zipcode=" + zipcode + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, id, street, zipcode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(city, other.city) && id == other.id && Objects.equals(street, other.street)
				&& Objects.equals(zipcode, other.zipcode);
	}

	
    
    
}
