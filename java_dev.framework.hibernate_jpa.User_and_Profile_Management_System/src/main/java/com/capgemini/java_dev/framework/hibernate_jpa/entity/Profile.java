package com.capgemini.java_dev.framework.hibernate_jpa.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Profile implements Serializable {
	@Id
    private int id;

    private String phone;
    private String gender;
    private LocalDate dob;

    @OneToOne(mappedBy = "profile")
    private User employee;

	public Profile() {
	}

	public Profile(int id, String phone, String gender, LocalDate dob) {
		this.id = id;
		this.phone = phone;
		this.gender = gender;
		this.dob = dob;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Profile [id=" + id + ", phone=" + phone + ", gender=" + gender + ", dob=" + dob + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dob, gender, id, phone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profile other = (Profile) obj;
		return Objects.equals(dob, other.dob) && Objects.equals(gender, other.gender) && id == other.id
				&& Objects.equals(phone, other.phone);
	}

	 
    
}
