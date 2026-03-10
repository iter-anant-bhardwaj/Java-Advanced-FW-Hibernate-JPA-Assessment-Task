package com.capgemini.java_dev.framework.hibernate_jpa.dao;


import com.capgemini.java_dev.framework.hibernate_jpa.entity.Address;
import com.capgemini.java_dev.framework.hibernate_jpa.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class EmployeeDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Employee");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();

    public void addEmployee(Employee emp) {

        et.begin();
        em.persist(emp);
        et.commit();

        System.out.println("Employee added successfully");
    }

    public Employee searchEmployee(int id) {

        return em.find(Employee.class, id);
    }

    public void updateSalary(int id, double salary) {

        Employee emp = em.find(Employee.class, id);

        if (emp != null) {

            et.begin();
            emp.setSalary(salary);
            et.commit();

            System.out.println("Employee salary updated successfully");
        } else {
            System.out.println("No employee found.");
        }
    }

    public void updateAddress(int id, String street, String city, String zip) {

        Employee emp = em.find(Employee.class, id);

        if (emp != null) {

            Address a = emp.getAddress();

            et.begin();
            a.setStreet(street);
            a.setCity(city);
            a.setZipcode(zip);
            et.commit();

            System.out.println("Address updated successfully");
        } else {
            System.out.println("No employee found.");
        }
    }

    public void deleteEmployee(int id) {

        Employee emp = em.find(Employee.class, id);

        if (emp != null) {

            et.begin();
            em.remove(emp);
            et.commit();

            System.out.println("Employee deleted successfully");
        } else {
            System.out.println("No employee found.");
        }
  }
}
