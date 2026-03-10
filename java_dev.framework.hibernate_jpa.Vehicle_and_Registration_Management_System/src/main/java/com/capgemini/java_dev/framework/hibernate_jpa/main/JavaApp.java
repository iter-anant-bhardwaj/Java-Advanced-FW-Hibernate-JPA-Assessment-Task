package com.capgemini.java_dev.framework.hibernate_jpa.main;

import java.time.LocalDate;
import java.util.Scanner;

import com.capgemini.java_dev.framework.hibernate_jpa.dao.DAO;
import com.capgemini.java_dev.framework.hibernate_jpa.entity.Vehicle;
import com.capgemini.java_dev.framework.hibernate_jpa.entity.Registration;



public class JavaApp {

	public static void execute() {

		Scanner sc = new Scanner(System.in);
        DAO dao = new DAO();

        while(true) {

            System.out.println("\n===== MENU =====");
            System.out.println("1 Add Vehicle");
            System.out.println("2 Search Vehicle");
            System.out.println("3 Update Registration Expiry");
            System.out.println("4 Delete Vehicle");
            System.out.println("5 Exit");

            int choice = sc.nextInt();

            switch(choice) {

            case 1:

                System.out.println("Enter id brand model regNumber expiryDate");
                int id = sc.nextInt();
                String brand = sc.next();
                String model = sc.next();
                String regNo = sc.next();
                String date = sc.next();

                Registration r = new Registration(id, regNo, LocalDate.parse(date));
                Vehicle v = new Vehicle(id, brand, model, r);

                dao.addVehicle(v);
                break;

            case 2:

                System.out.println("Enter Vehicle Id");
                dao.searchVehicle(sc.nextInt());
                break;

            case 3:

                System.out.println("Enter Vehicle Id");
                int vid = sc.nextInt();

                System.out.println("Enter New Expiry Date");
                LocalDate newDate = LocalDate.parse(sc.next());

                dao.updateExpiry(vid, newDate);
                break;

            case 4:

                System.out.println("Enter Vehicle Id");
                dao.deleteVehicle(sc.nextInt());
                break;

            case 5:
                System.exit(0);
            }
        }
    }
}