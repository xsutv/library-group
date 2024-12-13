package se.yrgo.models;

import java.util.*;

public class User {

        private String userID;
        private String name;
        private String lastName;
        private String adress;
        private String eMail;

        public User(String userID, String name, String lastName, String adress, String eMail) {
                this.userID = userID;
                this.name = name;
                this.lastName = lastName;
                this.adress = adress;
                this.eMail = eMail;
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

        public static List<User> getUserList() {
                return new ArrayList<>(List.of(
                                new User("234579128", "Leonard", "Björkengren", "Östra Storgatan 8, 553 21 Jönköping",
                                                "leo.björkengren@gmail.com"),
                                new User("457878321", "Alexander", "Johansson",
                                                "Drottninggatan 23B, 252 20 Helsingborg",
                                                "alex.johansson@hotmail.com"),
                                new User("325612654", "Elin", "Larsson", "Vaksalagatan 18, 753 20 Uppsala",
                                                "elin.larsson@example.com")));
        }

}
