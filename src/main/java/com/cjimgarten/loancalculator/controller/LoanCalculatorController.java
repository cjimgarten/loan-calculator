package com.cjimgarten.loancalculator.controller;

import com.cjimgarten.loancalculator.model.data.LoanDetailsDao;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private LoanDetailsDao dao;

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
        String amount = request.getParameter("amount");
        String term = request.getParameter("term");
        String interestRate = request.getParameter("interestRate");
        System.out.println(amount);
        System.out.println(term);
        System.out.println(interestRate);
        return "redirect:/calc/index";
    }

}
