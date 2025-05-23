/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package register;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class registerIT {

    register r = new register();  // Create a single instance for tests

    // Test a valid username (has underscore and is less than 5 characters)
    @Test
    public void testValidUsername() {
        String username = "jo_n";
        assertTrue(r.isUsernameValid(username), "Username should be valid");
    }

    // Test an invalid username (no underscore)
    @Test
    public void testInvalidUsernameNoUnderscore() {
        String username = "john";
        assertFalse(r.isUsernameValid(username), "Username should be invalid: no underscore");
    }

    // Test an invalid username (too long)
    @Test
    public void testInvalidUsernameTooLong() {
        String username = "john_doe";
        assertFalse(r.isUsernameValid(username), "Username should be invalid: too long");
    }

    // Test just the underscore checking function
    @Test
    public void testHasUnderscore() {
        assertTrue(r.hasUnderscore("user_name"), "Should detect underscore");
    }

    @Test
    public void testHasNoUnderscore() {
        assertFalse(r.hasUnderscore("username"), "Should detect no underscore");
    }
    
}
