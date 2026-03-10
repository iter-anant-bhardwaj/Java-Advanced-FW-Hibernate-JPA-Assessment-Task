package com.capgemini.java_dev.framework.hibernate_jpa.main;

import java.util.Scanner;


import com.capgemini.java_dev.framework.hibernate_jpa.entity.Wallet;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import com.capgemini.java_dev.framework.hibernate_jpa.entity.Customer;



public class JavaApp {

	public static void execute() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer-wallet");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== MENU =====");
            System.out.println("1 Add Customer");
            System.out.println("2 Search Customer");
            System.out.println("3 Update Wallet Balance");
            System.out.println("4 Delete Customer");
            System.out.println("5 Exit");

            int choice = sc.nextInt();

            switch (choice) {

            case 1:

                System.out.println("Enter Customer ID");
                int cid = sc.nextInt();

                sc.nextLine();
                System.out.println("Enter name");
                String name = sc.nextLine();

                System.out.println("Enter email");
                String email = sc.nextLine();

                System.out.println("Enter Wallet ID");
                int wid = sc.nextInt();

                System.out.println("Enter balance");
                double balance = sc.nextDouble();

                sc.nextLine();
                System.out.println("Enter currency");
                String currency = sc.nextLine();

                if(balance <= 0) {
                    System.out.println("Balance must be positive");
                    break;
                }

                Wallet wallet = new Wallet(wid, balance, currency);
                Customer customer = new Customer(cid, name, email, wallet);

                et.begin();
                em.persist(customer);
                et.commit();

                System.out.println("Customer added successfully");

                System.out.println("ID: " + customer.getId());
                System.out.println("Name: " + name);
                System.out.println("Email: " + email);
                System.out.println("Wallet:");
                System.out.println("  Balance: " + balance);
                System.out.println("  Currency: " + currency);

                break;

            case 2:

                System.out.println("Enter Customer ID");
                int id = sc.nextInt();

                Customer c = em.find(Customer.class, id);

                if(c != null) {

                    System.out.println("ID: " + c.getId());
                    System.out.println("Name: " + c.getName());
                    System.out.println("Email: " + c.getEmail());
                    System.out.println("Wallet:");
                    System.out.println("  Balance: " + c.getWallet().getBalance());
                    System.out.println("  Currency: " + c.getWallet().getCurrency());

                } else {
                    System.out.println("Customer not found");
                }

                break;

            case 3:

                System.out.println("Enter Customer ID");
                int uid = sc.nextInt();

                System.out.println("Enter new balance");
                double newBalance = sc.nextDouble();

                Customer cust = em.find(Customer.class, uid);

                if(cust != null) {

                    et.begin();

                    cust.getWallet().setBalance(newBalance);

                    em.merge(cust);

                    et.commit();

                    System.out.println("Wallet updated successfully");

                } else {
                    System.out.println("Customer not found");
                }

                break;

            case 4:

                System.out.println("Enter Customer ID");
                int did = sc.nextInt();

                Customer del = em.find(Customer.class, did);

                if(del != null) {

                    et.begin();
                    em.remove(del);
                    et.commit();

                    System.out.println("Customer deleted successfully");

                } else {
                    System.out.println("Customer not found");
                }

                break;

            case 5:
                System.exit(0);
            }
        }
    }
}