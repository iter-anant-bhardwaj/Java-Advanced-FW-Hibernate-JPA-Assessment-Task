package com.capgemini.java_dev.framework.hibernate_jpa.dao;


import com.capgemini.java_dev.framework.hibernate_jpa.entity.Profile;
import com.capgemini.java_dev.framework.hibernate_jpa.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;


public class DAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("User-Profile");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();

    public void addUser(User user) {

        et.begin();
        em.persist(user);
        et.commit();

        System.out.println("User added successfully");
    }

    public User searchUser(int id) {

        return em.find(User.class, id);
    }

    public void updateEmail(int id, String email) {

        User user = em.find(User.class, id);

        if (user != null) {

            et.begin();
            user.setEmail(email);
            et.commit();

            System.out.println("Email updated successfully");

        } else {
            System.out.println("No user found");
        }
    }

    public void updateProfile(int id, String phone, String gender, java.time.LocalDate dob) {

        User user = em.find(User.class, id);

        if (user != null) {

            Profile p = user.getProfile();

            et.begin();
            p.setPhone(phone);
            p.setGender(gender);
            p.setDob(dob);
            et.commit();

            System.out.println("Profile updated successfully");

        } else {
            System.out.println("No user found");
        }
    }

    public void deleteUser(int id) {

        User user = em.find(User.class, id);

        if (user != null) {

            et.begin();
            em.remove(user);
            et.commit();

            System.out.println("User deleted successfully");

        } else {
            System.out.println("No user found");
        }
    }
}