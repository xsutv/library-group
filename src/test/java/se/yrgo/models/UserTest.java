package se.yrgo.models;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
 
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

        // Perform the registration
        User.registerUser();

        // Retrieve the user list and check size
        List<User> users = User.getUserList();
        assertEquals(1, users.size(), "User list should contain 1 user");

        // Validate user details
        User registeredUser = users.get(0);
        assertEquals("234579128", registeredUser.getUserID());
        assertEquals("Leonard", registeredUser.getName());
        assertEquals("Björkengren", registeredUser.getLastName());
        assertEquals("Östra Storgatan 8, 553 21 Jönköping", registeredUser.getAdress());
        assertEquals("leo.björkengren@gmail.com", registeredUser.getEMail());
    }

    @Test
    void testRegisterUser_NotValidEmail() {
        // Simulate input with invalid email format
        String simulatedInput = "123456789\nJane\nSmith\n456 Elm St\ninvalid-email\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Perform the registration
        User.registerUser();

        // User should not be registered due to invalid email
        List<User> users = User.getUserList();
        assertTrue(users.isEmpty(), "User list should be empty after invalid email");
    }

    @Test
    void testRegisterUser_FieldEmpty() {
        // Simulate input with an empty first name
        String simulatedInput = "123456789\n\nSmith\n456 Elm St\njane.smith@example.com\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        User.registerUser();

        List<User> users = User.getUserList();
        assertTrue(users.isEmpty(), "User list should be empty due to empty first name");
    }

    @Test
    void testGetUserList() {
        // Ensure the static user list is initialized correctly
        List<User> users = User.getUserList();
        assertEquals(3, users.size(), "Static user list should contain 3 users initially");

        // Validate one of the static users
        User user = users.get(0);
        assertEquals("325612654", user.getUserID());
        assertEquals("Elin", user.getName());
        assertEquals("Larsson", user.getLastName());
    }
}
