package com.capgemini.java_dev.framework.hibernate_jpa.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Vehicle implements Serializable {
	@Id
    private int id;

    private String brand;
    private String model;

    @OneToOne(cascade = CascadeType.ALL)
    private Registration registration;
    

	public Vehicle() {
	}


	public Vehicle(int id, String brand, String model, Registration registration) {
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.registration = registration;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public Registration getRegistration() {
		return registration;
	}


	public void setRegistration(Registration registration) {
		this.registration = registration;
	}


	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", brand=" + brand + ", model=" + model + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(brand, id, model, registration);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		return Objects.equals(brand, other.brand) && id == other.id && Objects.equals(model, other.model)
				&& Objects.equals(registration, other.registration);
	}

	
	
}
