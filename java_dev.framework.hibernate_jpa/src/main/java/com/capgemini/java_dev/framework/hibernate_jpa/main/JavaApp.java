package com.capgemini.java_dev.framework.hibernate_jpa.main;

import java.util.Scanner;

import com.capgemini.java_dev.framework.hibernate_jpa.dao.ProductDAO;
import com.capgemini.java_dev.framework.hibernate_jpa.entity.Product;

public class JavaApp {
	public static void execute() {

        Scanner sc = new Scanner(System.in);
        ProductDAO dao = new ProductDAO();

        while (true) {

            System.out.println("\n----- Product Inventory Menu -----");
            System.out.println("1 Add Product");
            System.out.println("2 View All Products");
            System.out.println("3 Search Product by ID");
            System.out.println("4 Search Products by Category");
            System.out.println("5 Update Product Price");
            System.out.println("6 Delete Product");
            System.out.println("7 Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Add Product Name: ");
                    String name = sc.nextLine();

                    System.out.print("Category: ");
                    String category = sc.nextLine();

                    System.out.print("Price: ");
                    Double price = sc.nextDouble();

                    System.out.print("Quantity: ");
                    Integer quantity = sc.nextInt();

                    Product p = new Product(name, category, price, quantity);

                    dao.addProduct(p);

                    break;

                case 2:

                    dao.getAllProducts();
                    break;

                case 3:

                    System.out.print("Enter ID: ");
                    Integer id = sc.nextInt();

                    dao.getProductById(id);

                    break;

                case 4:

                    sc.nextLine();

                    System.out.print("Enter Category: ");
                    String cat = sc.nextLine();

                    dao.getProductsByCategory(cat);

                    break;

                case 5:

                    System.out.print("Enter Product ID: ");
                    int pid = sc.nextInt();

                    System.out.print("Enter New Price: ");
                    double newPrice = sc.nextDouble();

                    dao.updateProductPrice(pid, newPrice);

                    break;

                case 6:

                    System.out.print("Enter Product ID: ");
                    int did = sc.nextInt();

                    dao.deleteProduct(did);

                    break;

                case 7:

                    System.out.println("Exiting program...");
                    System.exit(0);

                default:

                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
