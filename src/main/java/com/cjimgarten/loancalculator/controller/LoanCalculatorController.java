package com.cjimgarten.loancalculator.controller;

import com.cjimgarten.loancalculator.model.LoanDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DecimalFormat;

/**
 * Created by chris on 7/30/17.
 */
@Controller
@RequestMapping(value = "calc")
public class LoanCalculatorController {

    private static LoanDetails loanDetails;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String redirect() {
        return "redirect:/calc/index";
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String indexGET(Model model) {
        model.addAttribute("title", "Loan Calculator");

        DecimalFormat df = new DecimalFormat("#,###.00");
        if (loanDetails != null) {
            model.addAttribute("amount",
                    "$" + df.format(loanDetails.getAmount()));
            model.addAttribute("monthlyPayment",
                    "$" + df.format(loanDetails.getMonthlyPayment()));
            model.addAttribute("totalPayment",
                    "$" + df.format(loanDetails.getTotalPayment()));
            model.addAttribute("totalInterest",
                    "$" + df.format(loanDetails.getTotalInterest()));
            model.addAttribute("annualPayment",
                    "$" + df.format(loanDetails.getAnnualPayment()));
        }
        return "calc/index";
    }

    @RequestMapping(value = "index", method = RequestMethod.POST)
    public String indexPOST(@RequestParam double amount,
                            @RequestParam double interestRate,
                            @RequestParam double term) {
        loanDetails = new LoanDetails(amount, interestRate, term);
        return "redirect:/calc/index";
    }
}
