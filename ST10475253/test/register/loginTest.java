/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package register;

import static org.junit.Assert.*;
import org.junit.Test;

public class loginTest {

    @Test
    public void testValidLogin() {
        login l = new login();
        boolean result = l.isValidLogin("admin", "1234", "admin", "1234");
        assertTrue(result);
    }

    @Test
    public void testInvalidUsername() {
        login l = new login();
        boolean result = l.isValidLogin("admin", "1234", "user", "1234");
        assertFalse(result);
    }

    @Test
    public void testInvalidPassword() {
        login l = new login();
        boolean result = l.isValidLogin("admin", "1234", "admin", "wrong");
        assertFalse(result);
    }

    @Test
    public void testInvalidLogin() {
        login l = new login();
        boolean result = l.isValidLogin("admin", "1234", "user", "wrong");
        assertFalse(result);
    }
}
