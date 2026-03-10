package com.capgemini.java_dev.framework.hibernate_jpa.main;

import java.util.Scanner;

import com.capgemini.java_dev.framework.hibernate_jpa.dao.EmployeeDAO;
import com.capgemini.java_dev.framework.hibernate_jpa.entity.Address;
import com.capgemini.java_dev.framework.hibernate_jpa.entity.Employee;

public class JavaApp {

	public static void execute() {

		Scanner sc = new Scanner(System.in);
		EmployeeDAO dao = new EmployeeDAO();

		while (true) {

			System.out.println("\n===== MENU =====");
			System.out.println("1 Add Employee");
			System.out.println("2 Search Employee");
			System.out.println("3 Update Salary");
			System.out.println("4 Update Address");
			System.out.println("5 Delete Employee");
			System.out.println("6 Exit");

			int choice = sc.nextInt();

			switch (choice) {

			case 1:

				Employee emp = new Employee();
				Address addr = new Address();

				System.out.println("Enter ID");
				int id = sc.nextInt();
				sc.nextLine();

				System.out.println("Enter Name");
				String name = sc.nextLine();

				System.out.println("Enter Email");
				String email = sc.nextLine();

				System.out.println("Enter Salary");
				double salary = sc.nextDouble();
				sc.nextLine();

				System.out.println("Enter Street");
				String street = sc.nextLine();

				System.out.println("Enter City");
				String city = sc.nextLine();

				System.out.println("Enter Zipcode");
				String zip = sc.nextLine();

				emp.setId(id);
				emp.setName(name);
				emp.setEmail(email);
				emp.setSalary(salary);

				addr.setId(id);
				addr.setStreet(street);
				addr.setCity(city);
				addr.setZipcode(zip);

				emp.setAddress(addr);

				dao.addEmployee(emp);

				break;

			case 2:

				System.out.println("Enter Employee ID");
				int searchId = sc.nextInt();

				Employee e = dao.searchEmployee(searchId);

				if (e != null) {

					System.out.println("ID: " + e.getId());
					System.out.println("Name: " + e.getName());
					System.out.println("Email: " + e.getEmail());
					System.out.println("Salary: " + e.getSalary());

					Address a = e.getAddress();

					System.out.println("Address:");
					System.out.println("Street: " + a.getStreet());
					System.out.println("City: " + a.getCity());
					System.out.println("Zipcode: " + a.getZipcode());

				} else {
					System.out.println("No employee found.");
				}

				break;

			case 3:

				System.out.println("Enter Employee ID");
				int id1 = sc.nextInt();

				System.out.println("Enter New Salary");
				double sal = sc.nextDouble();

				dao.updateSalary(id1, sal);

				break;

			case 4:

				System.out.println("Enter Employee ID");
				int id2 = sc.nextInt();
				sc.nextLine();

				System.out.println("Enter Street");
				String st = sc.nextLine();

				System.out.println("Enter City");
				String ct = sc.nextLine();

				System.out.println("Enter Zipcode");
				String zp = sc.nextLine();

				dao.updateAddress(id2, st, ct, zp);

				break;

			case 5:

				System.out.println("Enter Employee ID");
				int id3 = sc.nextInt();

				dao.deleteEmployee(id3);

				break;

			case 6:
				System.exit(0);
			}
		}
	}
}