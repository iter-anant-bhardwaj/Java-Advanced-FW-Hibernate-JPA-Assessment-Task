package com.capgemini.java_dev.framework.hibernate_jpa.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Registration implements Serializable {
	@Id
    private int id;

    private String registrationNumber;
    private LocalDate expiryDate;

    @OneToOne(mappedBy = "registration")
    private Vehicle vehicle;

	public Registration() {
	}

	public Registration(int id, String registrationNumber, LocalDate expiryDate) {
		this.id = id;
		this.registrationNumber = registrationNumber;
		this.expiryDate = expiryDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		return "Registration [id=" + id + ", registrationNumber=" + registrationNumber + ", expiryDate=" + expiryDate
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(expiryDate, id, registrationNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Registration other = (Registration) obj;
		return Objects.equals(expiryDate, other.expiryDate) && id == other.id
				&& Objects.equals(registrationNumber, other.registrationNumber);
	}

	
}
