package se.yrgo.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
        private String userID;
        private String name;
        private String lastName;
        private String adress;
        private String eMail;

        private static final List<User> userList = new ArrayList<>();

        // Constructor
        public User(String userID, String name, String lastName, String adress, String eMail) {
                this.userID = userID;
                this.name = name;
                this.lastName = lastName;
                this.adress = adress;
                this.eMail = eMail;
        }

        //Getters
        public String getUserID() {
                return userID;
        }

        public String getName() {
                return name;
        }

        public String getLastName() {
                return lastName;
        }

        public String getAdress() {
                return adress;
        }

        public String getEMail() {
                return eMail;
        }
        /**
         * Registration method. 
         * Scanner for input to all the membervariables. 
         * Create and add the new users.
         * Catch exception for user registration error. 
         * @author [Max Svensson, maxsve18 @github]
         */
        public static void registerUser() {
                try (Scanner scanner = new Scanner(System.in);) {
                        System.out.println("Enter User ID:");
                        String userID = scanner.nextLine().trim();
                        if (userID.isEmpty()) {
                                System.out.println("ID cannot be empty. Registration failed.");
                                return;
                        }

                        System.out.println("Enter First Name:");
                        String name = scanner.nextLine().trim();
                        if (name.isEmpty()) {
                                System.out.println("First name cannot be empty. Registration failed.");
                                return;
                        }

                        System.out.println("Enter Last Name:");
                        String lastName = scanner.nextLine().trim();
                        if (lastName.isEmpty()) {
                                System.out.println("Last Name cannot be empty. Registration failed.");
                                return;
                        }

                        System.out.println("Enter Address:");
                        String address = scanner.nextLine().trim();
                        if (address.isEmpty()) {
                                System.out.println("Address cannot be empty. Registration failed.");
                                return;
                        }

                        System.out.println("Enter Email:");
                        String email = scanner.nextLine().trim();
                        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                                System.out.println("Invalid email format. Registration failed.");
                                return;
                        }
                       
                        User newUser = new User(userID, name, lastName, address, email);
                        userList.add(newUser);

                        System.out.println("New user registered sucessfully: " + newUser);
                } catch (Exception e) {
                        System.err.println("User registration error: " + e.getMessage());
                }
        }

        /**
         * UserList of registrerd example users.
         * @author [Max Svensson, maxsve18 @github]
         */
        public static List<User> getUserList() {
                return new ArrayList<>(List.of(
                                new User("234579128", "Leonard", "Björkengren", "Östra Storgatan 8, 553 21 Jönköping",
                                                "leo.björkengren@gmail.com"),
                                new User("457878321", "Alexander", "Johansson",
                                                "Drottninggatan 23B, 252 20 Helsingborg", "alex.johansson@hotmail.com"),
                                new User("325612654", "Elin", "Larsson", "Vaksalagatan 18, 753 20 Uppsala",
                                                "elin.larsson@example.com")));
        }

        @Override
        public String toString() {
                return "User{" +
                                "userID='" + userID + '\'' +
                                ", name='" + name + '\'' +
                                ", lastName='" + lastName + '\'' +
                                ", adress='" + adress + '\'' +
                                ", eMail='" + eMail + '\'' +
                                '}';
        }

}