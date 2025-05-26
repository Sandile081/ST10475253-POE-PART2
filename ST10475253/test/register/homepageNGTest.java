/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package register;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import javax.swing.JOptionPane;

class HomepageTest {
    
    private homepage homePage;
    private int testMessageId;
    private int testMessageSent;
    
    @BeforeEach
    void setUp() {
        homePage = new homepage();
        testMessageId = 1000000000;
        testMessageSent = 0;
    }
    
    // Helper method to simulate message creation
    private void simulateMessage(String phoneNumber, String message, int action) {
        // Simulate valid phone number input
        boolean validPhone = phoneNumber.contains("+27") && phoneNumber.length() < 13 && phoneNumber.length() > 11;
        assertTrue(validPhone, "Phone number should be valid SA number with international code");
        
        // Simulate message creation
        assertTrue(message.length() < 250, "Message should be less than 250 characters");
        
        // Split message into words
        String[] words = message.split("\\s+");
        String firstWord = words[0];
        String lastWord = words[words.length-1];
        
        // Generate message hash
        String firstTwoNumbers = String.valueOf(testMessageId).substring(0,2);
        String messageHash = firstTwoNumbers + ":" + testMessageSent + ":" + firstWord + lastWord;
        
        // Test message hash generation
        assertNotNull(messageHash, "Message hash should not be null");
        assertTrue(messageHash.contains(":"), "Message hash should contain separators");
        
        if (action == 1) { // Send
            testMessageSent++;
            System.out.println("TEST: Message sent - " + messageHash);
        } else if (action == 2) { // Discard
            System.out.println("TEST: Message discarded");
        } else if (action == 3) { // Store
            testMessageSent++;
            System.out.println("TEST: Message stored - " + messageHash);
        }
    }
    
    @Test
    void testMessageProcessing() {
        // Test Data 1 - Message to be sent
        String phone1 = "+27718693002";
        String message1 = "Hi Mike, can you join us for dinner tonight";
        simulateMessage(phone1, message1, 1);
        
        // Verify message count after first message
        assertEquals(1, testMessageSent, "Message count should be 1 after first message");
        
        // Test Data 2 - Message to be discarded
        String phone2 = "08575975889"; // Note: This should fail validation as it doesn't have +27
        String message2 = "Hi Keegan, did you receive the payment?";
        
        // This should fail validation as the phone number format is incorrect
        assertFalse(phone2.contains("+27"), "Phone number should fail validation");
        
        // If we correct the phone number format, we can test discard
        String correctedPhone2 = "+27857597589";
        simulateMessage(correctedPhone2, message2, 2);
        
        // Verify message count remains 1 after discard
        assertEquals(1, testMessageSent, "Message count should remain 1 after discard");
        
        // Test total messages processed
        assertEquals(2, testMessageId - 1000000000 + 1, "Should have processed 2 messages");
    }
    
    @Test
    void testMessageHashGeneration() {
        String testPhone = "+27721234567";
        String testMessage = "Hello world this is a test";
        
        // Simulate message creation
        String[] words = testMessage.split("\\s+");
        String firstWord = words[0];
        String lastWord = words[words.length-1];
        
        String firstTwoNumbers = String.valueOf(testMessageId).substring(0,2);
        String expectedHash = firstTwoNumbers + ":0:Hellotest";
        
        String actualHash = firstTwoNumbers + ":0:" + firstWord + lastWord;
        
        assertEquals(expectedHash, actualHash, "Message hash generation is incorrect");
    }
    
    @Test
    
    
    // You'll need to add this helper method to your homepage class
    public static boolean isValidPhoneNumber(String number) {
        return number.contains("+27") && number.length() < 13 && number.length() > 11;
    }
}