package com.cjimgarten.loancalc.controller;

import com.cjimgarten.loancalc.model.Loan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import javax.validation.Valid;
import java.text.DecimalFormat;

/**
 * Created by chris on 7/30/17.
 */
@Controller
@RequestMapping(value = "")
public class LoanCalculatorController {

    private static final Logger LOG = LogManager.getLogger(LoanCalculatorController.class);
    private static Loan loan;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String indexGet(Model model) {

        LOG.info("Processing GET request");
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

        LOG.debug("GET processed successfully");
        return "index";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String indexPost(@ModelAttribute @Valid Loan ln,
                            Errors errors,
                            Model model) {

        LOG.info("Processing POST request");

        if (errors.hasErrors()) {
            model.addAttribute("title", "Loan Calculator");
            model.addAttribute("invalidSearch", "Invalid search criteria");
            LOG.debug("Invalid search processed");
            return "index";
        }
        loan = ln;
        LOG.debug("POST processed successfully");
        return "redirect:";
    }
}
