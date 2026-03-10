package com.capgemini.java_dev.framework.hibernate_jpa.dao;


import com.capgemini.java_dev.framework.hibernate_jpa.entity.Vehicle;

import java.time.LocalDate;

import com.capgemini.java_dev.framework.hibernate_jpa.entity.Registration;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class DAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("vehicle");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    // Add Vehicle
    public void addVehicle(Vehicle vehicle) {

        tx.begin();
        em.persist(vehicle);
        tx.commit();

        System.out.println("Vehicle added successfully");
    }

    // Search Vehicle
    public void searchVehicle(int id) {

        Vehicle v = em.find(Vehicle.class, id);

        if (v != null) {

            System.out.println("ID: " + v.getId());
            System.out.println("Brand: " + v.getBrand());
            System.out.println("Model: " + v.getModel());

            System.out.println("Registration:");
            System.out.println("  Number: " + v.getRegistration().getRegistrationNumber());
            System.out.println("  Expiry Date: " + v.getRegistration().getExpiryDate());

        } else {
            System.out.println("Vehicle not found");
        }
    }

    // Update Registration Expiry
    public void updateExpiry(int vehicleId, LocalDate newDate) {

        Vehicle v = em.find(Vehicle.class, vehicleId);

        if (v != null) {

            tx.begin();
            v.getRegistration().setExpiryDate(newDate);
            em.merge(v);
            tx.commit();

            System.out.println("Registration updated successfully");
        }
    }

    // Delete Vehicle
    public void deleteVehicle(int id) {

        Vehicle v = em.find(Vehicle.class, id);

        if (v != null) {

            tx.begin();
            em.remove(v);
            tx.commit();

            System.out.println("Vehicle deleted successfully");
        }
    }
}