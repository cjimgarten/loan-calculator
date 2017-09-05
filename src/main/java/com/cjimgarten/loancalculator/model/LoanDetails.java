package com.cjimgarten.loancalculator.model;

import javax.validation.constraints.NotNull;

/**
 * Created by chris on 7/30/17.
 */
public class LoanDetails {

    @NotNull private String amount;
    @NotNull private String interestRate;
    @NotNull private String term;

    public LoanDetails() {
        this("0.0", "0.0", "0.0");
    }

    public LoanDetails(String amount, String interestRate, String term) {
        this.amount = amount;
        this.interestRate = interestRate;
        this.term = term;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    // calculate the monthly payment
    public double calculateMonthlyPayment() {

        double amount = Double.parseDouble(this.amount);
        double interestRate = Double.parseDouble(this.interestRate);
        double term = Double.parseDouble(this.term);

        // variables needed to perform other calculations
        double n = term * 12.0; // payments per year times number of years
        double i = (interestRate * 0.01) / 12.0; // annual interest rate divided by number of
        // payments per year

        // calculate monthly loan payment
        double dfPow = Math.pow((1+i), n); // part of the discount factor formula
        double discountFactor = (dfPow - 1) / (i * dfPow); // not sure... just part of the formula
        return amount / discountFactor;
    }

    // calculate the total payment
    public double calculateTotalPayment() {

        double term = Double.parseDouble(this.term);

        // calculate and return the total payment
        double n = term * 12.0; // payments per year times number of years
        return calculateMonthlyPayment() * n;
    }

    // calculate the total interest
    public double calculateTotalInterest() {

        double amount = Double.parseDouble(this.amount);

        // calculate and return the total interest
        return calculateTotalPayment() - amount;
    }

    // calculate the annual payment
    public double calculateAnnualPayment() {

        // calculate and return the annual payment
        return calculateMonthlyPayment() * 12;
    }

    @Override
    public String toString() {
        return "[amount: " + amount +
                ", interestRate: " + interestRate +
                ", term: " + term + "]";
    }
}
