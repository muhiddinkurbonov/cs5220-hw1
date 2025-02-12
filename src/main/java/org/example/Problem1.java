package org.example;
import java.util.Scanner;

/**
    1. Write a Java program that acts as a simple calculator. The program should: (20
    points)
    a. Prompt the user to enter two integer numbers.
    b. Ask the user to choose an operation from the following:
    i. Addition
    ii. Subtraction
    iii. Multiplication
    iv. Division
    v. Modulus
    vi. Bitwise AND
    vii. Bitwise OR
    viii. Bitwise XOR
    ix. Find the larger number using a ternary operator
    c. Perform the selected operation and display the result.
    d. Use a switch statement to handle the user’s choice of operation.
 */

public class Problem1 {
    public static void main(String[] args) {
        int num1, num2;
        char operation;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        num1 = scanner.nextInt();
        System.out.print("Enter second number: ");
        num2 = scanner.nextInt();
        System.out.println("Choose an operation: +, -, *, /, %, &, |, ^, ?");
        operation = scanner.next().charAt(0);
        System.out.print("Result: ");
        calculate(operation, num1, num2);

    }

    private static void calculate(char operation, int num1, int num2) {
        switch (operation) {
            case '+':
                System.out.println(add(num1, num2));
                break;
            case '-':
                System.out.println(subtract(num1, num2));
                break;
            case '*':
                System.out.println(multiply(num1, num2));
                break;
            case '/':
                System.out.println(divide(num1, num2));
                break;
            case '%':
                System.out.println(modulus(num1, num2));
                break;
            case '&':
                System.out.println(bitwiseAnd(num1, num2));
                break;
            case '|':
                System.out.println(bitwiseOr(num1, num2));
                break;
            case '^':
                System.out.println(bitwiseXOR(num1, num2));
                break;
            case '?':
                System.out.println(largerNumber(num1, num2));
                break;
            default:
                System.out.println("Invalid input!");
        }
    }

    private static int add(int num1, int num2) {
        return num1 + num2;
    }

    private static int subtract(int num1, int num2) {
        return num1 - num2;
    }

    private static int multiply(int num1, int num2) {
        return num1 * num2;
    }

    private static String divide(int num1, int num2) {
        if(num2 == 0) return "divide by zero not allowed";
        return "" + (double) num1 / num2;
    }

    private static int modulus(int num1, int num2) {
        return num1 % num2;
    }
    private static int bitwiseAnd(int num1, int num2) {
        return num1 & num2;
    }
    private static int bitwiseOr(int num1, int num2) {
        return num1 | num2;
    }
    private static int bitwiseXOR(int num1, int num2) {
        return num1 ^ num2;
    }
    private static int largerNumber(int num1, int num2) {
        return num1 > num2 ? num1 : num2;
    }
}






