package com.cjimgarten.loancalculator.model;

/**
 * Created by chris on 9/3/17.
 */
public class LoanCalculations {

    private double monthlyPayment;
    private double totalPayment;
    private double totalInterest;
    private double annualPayment;

    public LoanCalculations() {

    }

    public LoanCalculations(double amount, double interestRate, double term) {
        calculate(amount, interestRate, term);
    }

    public void calculate(double amount, double interestRate, double term) {
        this.monthlyPayment = calculateMonthlyPayment(amount, interestRate, term);
        this.totalPayment = calculateTotalPayment(term);
        this.totalInterest = calculateTotalInterest(amount);
        this.annualPayment = calculateAnnualPayment();
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public double getTotalInterest() {
        return totalInterest;
    }

    public double getAnnualPayment() {
        return annualPayment;
    }

    private double calculateMonthlyPayment(double amount, double interestRate, double term) {

        // variables needed to perform other calculations
        double n = term * 12.0; // payments per year times number of years
        double i = (interestRate * 0.01) / 12.0; // annual interest rate divided by number of
        // payments per year

        // calculate monthly loan payment
        double dfPow = Math.pow((1+i), n); // part of the discount factor formula
        double discountFactor = (dfPow - 1) / (i * dfPow); // not sure... just part of the formula
        return amount / discountFactor;
    }

    private double calculateTotalPayment(double term) {
        // calculate and return the total payment
        double n = term * 12.0; // payments per year times number of years
        return this.monthlyPayment * n;
    }

    private double calculateTotalInterest(double amount) {
        // calculate and return the total interest
        return this.totalPayment - amount;
    }

    private double calculateAnnualPayment() {
        // calculate and return the annual payment
        return this.monthlyPayment * 12;
    }

    @Override
    public String toString() {
        return "[monthlyPayment: " + monthlyPayment +
                ", totalPayemnt: " + totalPayment +
                ", totalInterest: " + totalInterest +
                ", annualPayment: " + annualPayment + "]";
    }
}
