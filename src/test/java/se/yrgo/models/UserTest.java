package se.yrgo.models;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {
    private final InputStream originalSystemIn = System.in;

    @BeforeEach
    void setUp() {
        User.getUserList().clear();
    }

    @AfterEach
    void restoreSystemIn() {
        System.setIn(originalSystemIn);
    }

    @Test
    void testRegisterUser() {
        String simulatedInput = "234579128\nLeonard\nBjörkengren\nÖstra Storgatan 8, 553 21 Jönköping\nleo.björkengren@gmail.com\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Preforming Registration. 
        User.registerUser();

        // Retrieve the userlist and checks size. 
        List<User> users = User.getUserList();
        assertEquals(3, users.size(), "User list should contain 3 user");

        // Validate user details
        User registeredUser = users.get(0);
        assertEquals("234579128", registeredUser.getUserID());
        assertEquals("Leonard", registeredUser.getName());
        assertEquals("Björkengren", registeredUser.getLastName());
        assertEquals("Östra Storgatan 8, 553 21 Jönköping", registeredUser.getAdress());
        assertEquals("leo.björkengren@gmail.com", registeredUser.getEMail());
    }

    @Test
    void testGetUserList() {
        // Adds initial users directly to the static list
        User.getUserList().add(new User("234579128", "Leonard", "Björkengren",
                "Östra Storgatan 8, 553 21 Jönköping", "leo.björkengren@gmail.com"));
        User.getUserList().add(new User("457878321", "Alexander", "Johansson",
                "Drottninggatan 23B, 252 20 Helsingborg", "alex.johansson@hotmail.com"));
        User.getUserList().add(new User("325612654", "Elin", "Larsson",
                "Vaksalagatan 18, 753 20 Uppsala", "elin.larsson@example.com"));

        // Checks that user list is initialized correctly
        List<User> users = User.getUserList();
        assertEquals(3, users.size(), "Static user list should contain 3 users initially");

        // Validates  1 static user. 
        User user = users.get(0);
        assertEquals("234579128", user.getUserID());
        assertEquals("Leonard", user.getName());
        assertEquals("Björkengren", user.getLastName());
    }
}
