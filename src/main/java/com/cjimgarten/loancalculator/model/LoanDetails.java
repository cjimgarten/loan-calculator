package com.cjimgarten.loancalculator.model;

/**
 * Created by chris on 7/30/17.
 */
public class LoanDetails {

    private double amount;
    private double term;
    private double interestRate;

    public LoanDetails() {

    }

    public LoanDetails(double amount, double term, double interestRate) {
        this.amount = amount;
        this.term = term;
        this.interestRate = interestRate;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getTerm() {
        return this.term;
    }

    public void setTerm(double term) {
        this.term = term;
    }

    public double getInterestRate() {
        return this.interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
