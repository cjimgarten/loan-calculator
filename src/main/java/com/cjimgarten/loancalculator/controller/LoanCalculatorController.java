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

    private static Loan loanDetails;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String indexGET(Model model) {
        model.addAttribute("title", "Loan Calculator");

        DecimalFormat df = new DecimalFormat("#,###.00");
        if (loanDetails != null) {
            model.addAttribute("amount",
                    "$" + df.format(Double.parseDouble(loanDetails.getAmount())));
            model.addAttribute("interestRate",
                    loanDetails.getInterestRate() + "%");
            model.addAttribute("term",
                    loanDetails.getTerm() + " years");
            model.addAttribute("monthlyPayment",
                    "$" + df.format(loanDetails.calculateMonthlyPayment()));
            model.addAttribute("totalPayment",
                    "$" + df.format(loanDetails.calculateTotalPayment()));
            model.addAttribute("totalInterest",
                    "$" + df.format(loanDetails.calculateTotalInterest()));
            model.addAttribute("annualPayment",
                    "$" + df.format(loanDetails.calculateAnnualPayment()));
        }
        return "index";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String indexPOST(@ModelAttribute @Valid Loan ld,
                            Errors errors) {

        // DEBUG
        System.out.println(ld);

        /**
         * Loan ld = new Loan();
         * ld.setAmount(request.getParameter("amount"));
         * ld.setInterestRate(request.getParameter("interestRate));
         * ld.setTerm(request.getParameter("term"));
         */

        if (errors.hasErrors()) {

            // LOG MESSAGE
            System.out.println(errors.getFieldError());
            return "redirect:";
        }

        loanDetails = ld;
        return "redirect:";
    }
}
