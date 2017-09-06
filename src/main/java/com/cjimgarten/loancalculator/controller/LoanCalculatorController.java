package com.cjimgarten.loancalculator.controller;

import com.cjimgarten.loancalculator.model.Loan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.text.DecimalFormat;

/**
 * Created by chris on 7/30/17.
 */
@Controller
@RequestMapping(value = "")
public class LoanCalculatorController {

    private static Loan loan;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String indexGET(Model model) {
        model.addAttribute("title", "Loan Calculator");

        DecimalFormat df = new DecimalFormat("#,###.00");
        if (loan != null) {
            model.addAttribute("amount",
                    "$" + df.format(Double.parseDouble(loan.getAmount())));
            model.addAttribute("interestRate",
                    loan.getInterestRate() + "%");
            model.addAttribute("term",
                    loan.getTerm() + " years");
            model.addAttribute("monthlyPayment",
                    "$" + df.format(loan.calculateMonthlyPayment()));
            model.addAttribute("totalPayment",
                    "$" + df.format(loan.calculateTotalPayment()));
            model.addAttribute("totalInterest",
                    "$" + df.format(loan.calculateTotalInterest()));
            model.addAttribute("annualPayment",
                    "$" + df.format(loan.calculateAnnualPayment()));
        }
        return "index";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String indexPOST(@ModelAttribute @Valid Loan ln,
                            Errors errors,
                            Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Loan Calculator");
            model.addAttribute("invalidSearch", "Invalid search criteria");
            return "index";
        }
        loan = ln;
        return "redirect:";
    }
}
