package com.cjimgarten.loancalculator.model;

/**
 * Created by chris on 7/30/17.
 */
public class LoanDetails {

    private double amount;
    private double interestRate;
    private double term;

    public LoanDetails() {

    }

    public LoanDetails(double amount, double interestRate, double term) {
        this.amount = amount;
        this.interestRate = interestRate;
        this.term = term;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
        calculatePayment();
    }

    public double getInterestRate() {
        return this.interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
        calculatePayment();
    }

    public double getTerm() {
        return this.term;
    }

    public void setTerm(double term) {
        this.term = term;
        calculatePayment();
    }

    public void calculatePayment() {
        // TODO calculate loan payment
        System.out.println(amount);
        System.out.println(interestRate);
        System.out.println(term);
    }
}
