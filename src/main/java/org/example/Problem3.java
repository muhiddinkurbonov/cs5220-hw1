package org.example;

import java.util.Scanner;

/**
 * Write a Java program to evaluate the strength of a password string entered by the
 * user based on predefined criteria. The program should: (30 points)
 * a. Prompt the user to enter a password.
 * b. Check and display the following password properties:
 *      i. Length: Should be at least 8 characters.
 *      ii. Uppercase letter: Should contain at least one uppercase letter (A-Z).
 *      iii. Lowercase letter: Should contain at least one lowercase letter (a-z).
 *      iv. Digit: Should contain at least one number (0-9).
 *      v. Special character: Should contain at least one special character
 *          (!@#$%^&*()-+=<>?/{}[]|).
 * c. Classify based on its strength:
 *      i. Weak: If it meets fewer than 3 of the above criteria.
 *      ii. Moderate: If it meets 3 or 4 criteria.
 *      iii. Strong: If it meets all 5 criteria.
 */

public class Problem3 {
    final static String specialChars = "!@#$%^&*()-+=<>?/{}[]|";

    public static void main(String[] args) {

        System.out.print("Enter your password: ");
        Scanner scanner = new Scanner(System.in);
        String password = scanner.next();

        char[] chars = password.toCharArray();

        if(passwordLengthShouldBeEightChars(chars)) {
            System.out.println("Password Length: (Valid)");
        } else {
            System.out.println("Password Length: (Invalid)");
        }

        if(containUpperCase(chars)) {
            System.out.println("UpperCase Letter:  (Valid)");
        } else {
            System.out.println("UpperCase Letter:  (Invalid)");
        }

        if(containLowerCase(chars)) {
            System.out.println("LowerCase Letter:  (Valid)");
        } else {
            System.out.println("LowerCase Letter:  (Invalid)");
        }

        if(containDigit(chars)) {
            System.out.println("Digit: (Valid)");
        } else {
            System.out.println("Digit: (Invalid)");
        }

        if(containSpecialChars(chars)) {
            System.out.println("Special Character: (Valid)");
        } else {
            System.out.println("Special Character: (Invalid)");
        }

        int criteriaCount = passwordStrength(chars);
        if(criteriaCount < 3) {
            System.out.println("Password Strength: WEAK");
        } else if(criteriaCount <= 4) {
            System.out.println("Password Strength: MODERATE");
        } else if(criteriaCount == 5) {
            System.out.println("Password Strength: STRONG");
        }


    }

    private static boolean passwordLengthShouldBeEightChars(char[] chars) {
        return chars.length >= 8 ? true : false;
    }

    private static boolean containUpperCase(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] >= 65 && chars[i] <= 90) return true;
        }
        return false;
    }

    private static boolean containLowerCase(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] >= 97 && chars[i] <= 122) return true;
        }
        return false;
    }

    private static boolean containDigit(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] >= 48 && chars[i] <= 57) return true;
        }
        return false;
    }

    private static boolean containSpecialChars(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if(specialChars.indexOf(chars[i]) != -1) {
                return true;
            }
        }
        return false;
    }

    private static int passwordStrength(char[] chars) {
        int count = 0;
        if(passwordLengthShouldBeEightChars(chars)) count++;
        if(containUpperCase(chars)) count++;
        if(containLowerCase(chars)) count++;
        if(containDigit(chars)) count++;
        if(containSpecialChars(chars)) count++;

        return count;
    }
}
