package com.cjimgarten.loancalculator.model;

import javax.validation.constraints.NotNull;

/**
 * Created by chris on 7/30/17.
 */
public class LoanDetails {

    @NotNull private String amount;
    @NotNull private String interestRate;
    @NotNull private String term;
    private LoanCalculations loanCalculations;

    public LoanDetails() {
        this("0.0", "0.0", "0.0");
    }

    public LoanDetails(String amount, String interestRate, String term) {
        this.amount = amount;
        this.interestRate = interestRate;
        this.term = term;
        this.loanCalculations = new LoanCalculations(
                Double.parseDouble(amount),
                Double.parseDouble(interestRate),
                Double.parseDouble(term));
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
        loanCalculations.calculate(
                Double.parseDouble(this.amount),
                Double.parseDouble(this.interestRate),
                Double.parseDouble(this.term));
    }

    public String getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
        loanCalculations.calculate(
                Double.parseDouble(this.amount),
                Double.parseDouble(this.interestRate),
                Double.parseDouble(this.term));
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
        loanCalculations.calculate(
                Double.parseDouble(this.amount),
                Double.parseDouble(this.interestRate),
                Double.parseDouble(this.term));
    }

    public LoanCalculations getLoanCalculations() {
        return loanCalculations;
    }


    @Override
    public String toString() {
        return "[amount: " + amount +
                ", interestRate: " + interestRate +
                ", term: " + term +
                ", loanCalculations: " + loanCalculations + "]";
    }
}
