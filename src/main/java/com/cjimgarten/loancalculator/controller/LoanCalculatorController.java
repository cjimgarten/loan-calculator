package com.cjimgarten.loancalculator.controller;

import com.cjimgarten.loancalculator.model.LoanDetails;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        return "index";
    }

    @RequestMapping(value = "index", method = RequestMethod.POST)
    public String indexPOST(HttpServletRequest request) {
        loanDetails = new LoanDetails(
                Double.parseDouble(request.getParameter("amount")),
                Double.parseDouble(request.getParameter("interestRate")),
                Double.parseDouble(request.getParameter("term"))
        );
        loanDetails.calculatePayment();
        return "redirect:/calc/index";
    }
}
