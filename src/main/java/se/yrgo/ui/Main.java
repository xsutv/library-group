package se.yrgo.ui;

import java.io.*;
import java.util.*;

import se.yrgo.models.*;

public class Main {
    public static void main(String[] args) throws IOException {

        // visa vem du är inloggad som en användare
        // loan book
        // add review

        List<String> options = new ArrayList<>(List.of("Add book", "Rent book", "Add book review"));

        User loggedInUser = new User("123abc", "Björn", "Järnsida", "Kattigatt 37", "getgood@outlook.com");

        System.out.println("You're logged in as: " + loggedInUser.getName() + " " + loggedInUser.getLastName());

        System.out.printf("%nEnter number of what you want to do: %n");

        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
    }
}