package com.capgemini.java_dev.framework.hibernate_jpa.dao;

import java.util.List;

import com.capgemini.java_dev.framework.hibernate_jpa.entity.Product;

import jakarta.persistence.*;


public class ProductDAO {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProductUnit");

    EntityManager em = emf.createEntityManager();

    
    public void addProduct(Product p) {

        if(p.getName() == null || p.getName().trim().isEmpty() ||
           p.getCategory() == null || p.getCategory().trim().isEmpty()) {

            System.out.println("Name and Category cannot be empty.");
            return;
        }

        if(p.getPrice() <= 0 || p.getQuantity() <= 0) {
            System.out.println("Price and Quantity must be positive.");
            return;
        }

        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(p);
        et.commit();

        System.out.println("Product added successfully.");
        p.display();
    }

    
    public void getAllProducts() {

        Query q = em.createQuery("SELECT p FROM Product p");

        List<Product> list = q.getResultList();

        if (list.isEmpty()) {
            System.out.println("No product found.");
            return;
        }

        for (Product p : list) {
            p.display();
        }
    }

    
    public void getProductById(int id) {

        Product p = em.find(Product.class, id);

        if (p == null) {
            System.out.println("No product found.");
        } else {
            p.display();
        }
    }

    
    public void getProductsByCategory(String category) {

        Query q = em.createQuery(
                "SELECT p FROM Product p WHERE p.category = :category");

        q.setParameter("category", category);

        List<Product> list = q.getResultList();

        if (list.isEmpty()) {
            System.out.println("No product found.");
            return;
        }

        for (Product p : list) {
            p.display();
        }
    }


    public void updateProductPrice(int id, double newPrice) {

        if(newPrice <= 0) {
            System.out.println("Price must be positive.");
            return;
        }

        Product p = em.find(Product.class, id);

        if (p == null) {
            System.out.println("No product found.");
            return;
        }

        EntityTransaction et = em.getTransaction();

        et.begin();
        p.setPrice(newPrice);
        em.merge(p);
        et.commit();

        System.out.println("Product price updated successfully.");
        p.display();
    }

    
    public void deleteProduct(int id) {

        Product p = em.find(Product.class, id);

        if (p == null) {
            System.out.println("No product found.");
            return;
        }

        EntityTransaction et = em.getTransaction();

        et.begin();
        em.remove(p);
        et.commit();

        System.out.println("Product deleted successfully.");
    }
}
