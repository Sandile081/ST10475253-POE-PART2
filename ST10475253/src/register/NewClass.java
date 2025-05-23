/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// File: RegisterValidator.java
package register;

public class NewClass {

    public static boolean isUsernameValid(String username) {
        return username.contains("_") && username.length() < 5;
    }

    public static boolean isMobileNumberValid(String number) {
        return number.contains("+27") && number.length() < 13 && number.length() > 11;
    }

    public static boolean isPasswordValid(String password) {
        return password.length() < 9 &&
               !password.contains(" ") &&
               password.chars().anyMatch(Character::isUpperCase) &&
               password.chars().anyMatch(Character::isLowerCase) &&
               password.chars().anyMatch(Character::isDigit) &&
               password.chars().anyMatch(ch -> !Character.isLetterOrDigit(ch));
    }
}