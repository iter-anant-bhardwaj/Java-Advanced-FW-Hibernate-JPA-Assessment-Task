package com.capgemini.java_dev.framework.hibernate_jpa.main;

import java.time.LocalDate;
import java.util.Scanner;

import com.capgemini.java_dev.framework.hibernate_jpa.dao.DAO;
import com.capgemini.java_dev.framework.hibernate_jpa.entity.Profile;
import com.capgemini.java_dev.framework.hibernate_jpa.entity.User;



public class JavaApp {

	public static void execute() {

		Scanner sc = new Scanner(System.in);
        DAO dao = new DAO();

        while (true) {

            System.out.println("\n===== MENU =====");
            System.out.println("1 Add User");
            System.out.println("2 Search User");
            System.out.println("3 Update Email");
            System.out.println("4 Update Profile");
            System.out.println("5 Delete User");
            System.out.println("6 Exit");

            int choice = sc.nextInt();

            switch (choice) {

            case 1:

                User user = new User();
                Profile profile = new Profile();

                System.out.println("Enter ID");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.println("Enter Username");
                String username = sc.nextLine();

                System.out.println("Enter Email");
                String email = sc.nextLine();

                System.out.println("Enter Phone");
                String phone = sc.nextLine();

                System.out.println("Enter Gender");
                String gender = sc.nextLine();

                System.out.println("Enter DOB (yyyy-MM-dd)");
                String dobStr = sc.nextLine();

                LocalDate dob = LocalDate.parse(dobStr);

                user.setId(id);
                user.setUsername(username);
                user.setEmail(email);

                profile.setId(id);
                profile.setPhone(phone);
                profile.setGender(gender);
                profile.setDob(dob);

                user.setProfile(profile);

                dao.addUser(user);

                break;

            case 2:

                System.out.println("Enter User ID");
                int searchId = sc.nextInt();

                User u = dao.searchUser(searchId);

                if (u != null) {

                    System.out.println("ID: " + u.getId());
                    System.out.println("Username: " + u.getUsername());
                    System.out.println("Email: " + u.getEmail());

                    Profile p = u.getProfile();

                    System.out.println("Profile:");
                    System.out.println("Phone: " + p.getPhone());
                    System.out.println("Gender: " + p.getGender());
                    System.out.println("DOB: " + p.getDob());

                } else {
                    System.out.println("No user found");
                }

                break;

            case 3:

                System.out.println("Enter User ID");
                int id1 = sc.nextInt();
                sc.nextLine();

                System.out.println("Enter New Email");
                String newEmail = sc.nextLine();

                dao.updateEmail(id1, newEmail);

                break;

            case 4:

                System.out.println("Enter User ID");
                int id2 = sc.nextInt();
                sc.nextLine();

                System.out.println("Enter Phone");
                String ph = sc.nextLine();

                System.out.println("Enter Gender");
                String gen = sc.nextLine();

                System.out.println("Enter DOB (yyyy-MM-dd)");
                String dobInput = sc.nextLine();

                LocalDate newDob = LocalDate.parse(dobInput);

                dao.updateProfile(id2, ph, gen, newDob);

                break;

            case 5:

                System.out.println("Enter User ID");
                int id3 = sc.nextInt();

                dao.deleteUser(id3);

                break;

            case 6:
                System.exit(0);
            }
        }
    }
}