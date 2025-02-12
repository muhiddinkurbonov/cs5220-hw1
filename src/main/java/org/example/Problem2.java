package org.example;

import java.util.Scanner;

/**
 * Write a Java program that helps analyze stock price for a company over a period
 * of N days. The program should: (30 points)
 * a. Accept stock prices for N days from the user and store them in an array.
 * b. Find and display the following:
 *      i. Highest stock price and the day it occurred.
 *      ii. Lowest stock price and the day it occurred.
 *      iii. Average stock price over the given period.
 * c. Find the best day to buy and sell to maximize profit, assuming the user buys
 * at the lowest price before selling at the highest price later.
 * d. Check if the stock prices were in increasing order.
 */

public class Problem2 {
    public static void main(String[] args) {

        double[] stockPrices;
        System.out.print("Enter the number of days: ");

        Scanner scanner = new Scanner(System.in);
        int days = scanner.nextInt();
        stockPrices = new double[days];
        System.out.println("Enter stock prices for " + days + " days:");

        for (int i = 0; i < days; i++) {
            stockPrices[i] = scanner.nextDouble();
        }

        // Highest stock price
        Number[] highestArr = highest(stockPrices);
        Number highestStockPrice = highestArr[0];
        Number highestStockPriceDay = highestArr[1];
        System.out.println("Highest stock price: " + highestStockPrice + " on day " + highestStockPriceDay);

        // Lowest stock price
        Number[] lowestArr = lowest(stockPrices);
        Number lowestStockPrice = lowestArr[0];
        Number lowestStockPriceDay = lowestArr[1];
        System.out.println("Lowest stock price: " + lowestStockPrice + " on day " + lowestStockPriceDay);

        // Average stock price
        System.out.printf("Average stock price: %.2f%n", average(stockPrices));

        Number bestDayToBuy = bestDayToBuyAndSell(stockPrices)[0];
        Number bestDayToSell = bestDayToBuyAndSell(stockPrices)[1];
        Number maxProfit = bestDayToBuyAndSell(stockPrices)[2];

        System.out.println("Best day to buy: Day " + bestDayToBuy + " (Price: " + stockPrices[bestDayToBuy.intValue()-1] + ")");
        System.out.println("Best day to sell: Day " + bestDayToSell + " (Price: " + stockPrices[bestDayToSell.intValue()-1] + ")");
        System.out.println("Maximum profit: " + maxProfit);


        // If stock prices are in increasing order
        if(increasing(stockPrices)) {
            System.out.println("Stock prices are in increasing order.");
        } else {
            System.out.println("Stock prices are NOT in incresing order.");
        }

    }
    private static Number[] highest(double[] stockPrices) { // I used Number type to get both double and int as a result array
        double max = stockPrices[0];
        int dayMax = 1;
        Number [] result = {max, dayMax};
        for (int i = 1; i < stockPrices.length; i++) {
            if(stockPrices[i] > max) {
                max = stockPrices[i];
                dayMax = i + 1;
                result[0] = max;
                result[1] = dayMax;
            }
        }
        return result;
    }

    private static Number[] lowest(double[] stockPrices) { // I used Number type to get both double and int as a result array
        double min = stockPrices[0];
        int dayMin = 1;
        Number [] result = {min, dayMin};
        for (int i = 1; i < stockPrices.length; i++) {
            if(stockPrices[i] < min) {
                min = stockPrices[i];
                dayMin = i + 1;
                result[0] = min;
                result[1] = dayMin;
            }
        }
        return result;
    }

    private static double average(double[] stockPrices) {
        int len = stockPrices.length;
        double sum = 0;
        double avg = 0;
        for (int i = 0; i < len; i++) {
            sum += stockPrices[i];
        }
        avg = sum / len;
        return avg;
    }

    private static Number[] bestDayToBuyAndSell(double[] stockPrices) {
        int len = stockPrices.length;
        double maxProfit = 0;
        int buyDay = 0;
        int sellDay = 0;
        double minPriceSoFar = stockPrices[0];

        for (int i = 1; i < len; i++) {
            if (stockPrices[i] < minPriceSoFar) {
                minPriceSoFar = stockPrices[i];
                // Reset buyDay when a new minimum price is found
                buyDay = i + 1;
            } else {
                double currentProfit = stockPrices[i] - minPriceSoFar;
                if (currentProfit > maxProfit) {
                    maxProfit = currentProfit;
                    sellDay = i + 1;
                }
            }
        }

        return new Number[]{buyDay, sellDay, maxProfit};
    }

    private static boolean increasing(double[] stockPrices) {
        int len = stockPrices.length;
        double firstPrice = stockPrices[0];
        for (int i = 1; i < len; i++) {
            if(stockPrices[i] < firstPrice) {
                return false;
            }
        }
        return true;
    }
}
