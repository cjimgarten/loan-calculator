package com.cjimgarten.loancalculator.model;

/**
 * Created by chris on 7/30/17.
 */
public class LoanDetails {

    private double amount;
    private double interestRate;
    private double term;
    private double monthlyPayment;
    private double totalPayment;
    private double totalInterest;
    private double annualPayment;

    public LoanDetails() {

    }

    public LoanDetails(double amount, double interestRate, double term) {
        this.amount = amount;
        this.interestRate = interestRate;
        this.term = term;
        refresh();
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
        refresh();
    }

    public double getInterestRate() {
        return this.interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
        refresh();
    }

    public double getTerm() {
        return this.term;
    }

    public void setTerm(double term) {
        this.term = term;
        refresh();
    }

    public double getMonthlyPayment() {
        return this.monthlyPayment;
    }

    public double getTotalPayment() {
        return this.totalPayment;
    }

    public double getTotalInterest() {
        return this.totalInterest;
    }

    public double getAnnualPayment() {
        return this.annualPayment;
    }

    public void refresh() {
        calculateMonthlyPayment();
        calculateTotalPayment();
        calculateTotalInterest();
        calculateAnnualPayment();
    }

    public void calculateMonthlyPayment() {

        // variables needed to perform other calculations
        double n = this.term * 12.0; // payments per year times number of years
        double i = (this.interestRate * 0.01) / 12.0; // annual interest rate divided by number of payments per year

        // calculate monthly loan payment
        double dfPow = Math.pow((1+i), n); // part of the discount factor formula
        double discountFactor = (dfPow - 1) / (i * dfPow); // not sure... just part of the formula
        this.monthlyPayment = this.amount / discountFactor;
    }

    public void calculateTotalPayment() {
        // TODO calculate the total payment
        double n = this.term * 12.0; // payments per year times number of years
        this.totalPayment = this.monthlyPayment * n;
    }

    public void calculateTotalInterest() {
        // TODO calculate the total interest
        this.totalInterest = this.totalPayment - this.amount;
    }

    public void calculateAnnualPayment() {
        // TODO calculate the annual payment
        this.annualPayment = this.monthlyPayment * 12;
    }
}
