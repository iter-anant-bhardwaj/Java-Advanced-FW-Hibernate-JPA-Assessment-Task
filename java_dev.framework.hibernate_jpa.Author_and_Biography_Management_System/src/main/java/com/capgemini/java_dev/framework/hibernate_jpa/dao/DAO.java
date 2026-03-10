package com.capgemini.java_dev.framework.hibernate_jpa.dao;


import com.capgemini.java_dev.framework.hibernate_jpa.entity.Author;
import com.capgemini.java_dev.framework.hibernate_jpa.entity.Biography;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class DAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Author-Bio");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();

    public void addAuthor(Author author) {

        et.begin();
        em.persist(author);
        et.commit();

        System.out.println("Author added successfully");
    }

    public Author searchAuthor(int id) {

        return em.find(Author.class, id);
    }

    public void updateBiography(int id, String summary, String birthPlace, java.time.LocalDate birthDate) {

        Author author = em.find(Author.class, id);

        if (author != null) {

            Biography bio = author.getBiography();

            et.begin();
            bio.setSummary(summary);
            bio.setBirthPlace(birthPlace);
            bio.setBirthDate(birthDate);
            et.commit();

            System.out.println("Biography updated successfully");

        } else {
            System.out.println("No author found");
        }
    }

    public void deleteAuthor(int id) {

        Author author = em.find(Author.class, id);

        if (author != null) {

            et.begin();
            em.remove(author);
            et.commit();

            System.out.println("Author deleted successfully");

        } else {
            System.out.println("No author found");
        }
    }
}