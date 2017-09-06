package com.cjimgarten.loancalculator.util;

/**
 * Created by chris on 9/2/17.
 */
public class LoanUtils {

    // TODO calculate monthly payment
    public static double calculateMonthlyPayment(double amount, double interestRate, double term) {
        return 0.0;
    }

    // TODO calculate total payment
    public static double calculateTotalPayment(double monthlyPayment, double term) {
        return 0.0;
    }

    // calculate total interest
    public static double calculateTotalInterest(double totalPayment, double amount) {
        return totalPayment - amount;
    }

    // calculate annual payment
    public static double calculateAnnualPayment(double monthlyPayment) {
        return monthlyPayment * 12;
    }
}
