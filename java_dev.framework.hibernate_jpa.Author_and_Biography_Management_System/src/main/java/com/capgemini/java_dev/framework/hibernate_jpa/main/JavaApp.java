package com.capgemini.java_dev.framework.hibernate_jpa.main;

import java.time.LocalDate;
import java.util.Scanner;

import com.capgemini.java_dev.framework.hibernate_jpa.dao.DAO;
import com.capgemini.java_dev.framework.hibernate_jpa.entity.Author;
import com.capgemini.java_dev.framework.hibernate_jpa.entity.Biography;



public class JavaApp {

	public static void execute() {

		Scanner sc = new Scanner(System.in);
        DAO dao = new DAO();

        while (true) {

            System.out.println("\n===== MENU =====");
            System.out.println("1 Add Author");
            System.out.println("2 Search Author");
            System.out.println("3 Update Biography");
            System.out.println("4 Delete Author");
            System.out.println("5 Exit");

            int choice = sc.nextInt();

            switch (choice) {

            case 1:

                Author author = new Author();
                Biography bio = new Biography();

                System.out.println("Enter ID");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.println("Enter Name");
                String name = sc.nextLine();

                System.out.println("Enter Email");
                String email = sc.nextLine();

                System.out.println("Enter Summary");
                String summary = sc.nextLine();

                System.out.println("Enter Birth Place");
                String birthPlace = sc.nextLine();

                System.out.println("Enter Birth Date (yyyy-MM-dd)");
                String date = sc.nextLine();

                LocalDate birthDate = LocalDate.parse(date);

                author.setId(id);
                author.setName(name);
                author.setEmail(email);

                bio.setId(id);
                bio.setSummary(summary);
                bio.setBirthPlace(birthPlace);
                bio.setBirthDate(birthDate);

                author.setBiography(bio);

                dao.addAuthor(author);

                break;

            case 2:

                System.out.println("Enter Author ID");
                int searchId = sc.nextInt();

                Author a = dao.searchAuthor(searchId);

                if (a != null) {

                    System.out.println("ID: " + a.getId());
                    System.out.println("Name: " + a.getName());
                    System.out.println("Email: " + a.getEmail());

                    Biography b = a.getBiography();

                    System.out.println("Biography:");
                    System.out.println("Summary: " + b.getSummary());
                    System.out.println("Birth Place: " + b.getBirthPlace());
                    System.out.println("Birth Date: " + b.getBirthDate());

                } else {
                    System.out.println("No author found");
                }

                break;

            case 3:

                System.out.println("Enter Author ID");
                int id2 = sc.nextInt();
                sc.nextLine();

                System.out.println("Enter Summary");
                String sum = sc.nextLine();

                System.out.println("Enter Birth Place");
                String bp = sc.nextLine();

                System.out.println("Enter Birth Date (yyyy-MM-dd)");
                String d = sc.nextLine();

                LocalDate bd = LocalDate.parse(d);

                dao.updateBiography(id2, sum, bp, bd);

                break;

            case 4:

                System.out.println("Enter Author ID");
                int delId = sc.nextInt();

                dao.deleteAuthor(delId);

                break;

            case 5:
                System.exit(0);
            }
        }
    }
}