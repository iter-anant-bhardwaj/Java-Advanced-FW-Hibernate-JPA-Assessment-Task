package com.capgemini.java_dev.framework.hibernate_jpa.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Wallet implements Serializable {
	@Id
    private Integer id;
    private Double balance;
    private String currency;
    

	public Wallet() {
	}


	public Wallet(Integer id, Double balance, String currency) {
		this.id = id;
		this.balance = balance;
		this.currency = currency;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(Double balance) {
		this.balance = balance;
	}


	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}


	@Override
	public String toString() {
		return "Wallet [id=" + id + ", balance=" + balance + ", currency=" + currency + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(balance, currency, id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wallet other = (Wallet) obj;
		return Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance)
				&& Objects.equals(currency, other.currency) && id == other.id;
	}


		
}
