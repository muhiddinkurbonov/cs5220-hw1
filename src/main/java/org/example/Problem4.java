package org.example;

import java.util.Scanner;

public class Problem4 {
    public static void main(String[] args) {
        System.out.print("Enter a phrase: ");
        Scanner scanner = new Scanner(System.in);
        String phrase = scanner.nextLine();
        StringBuilder abbreviated = abbreviate(phrase);
        System.out.println(abbreviated);
    }

    private static StringBuilder abbreviate(String phrase) {
        String[] wordsArr = phrase.split(" ");
        StringBuilder abbr = new StringBuilder();
        for (int i = 0; i < wordsArr.length; i++) {
            if(wordsArr[i].charAt(0) >= 65 && wordsArr[i].charAt(0) <= 90) {
                abbr.append(wordsArr[i].charAt(0));
            }
        }
        return abbr;
    }
}
