package com.cjimgarten.loancalc.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * Created by chris on 9/2/17.
 */
@SpringBootApplication(scanBasePackages = "com.cjimgarten.loancalc")
public class LoanCalculatorApplication {

    private static final Logger LOG = LogManager.getLogger(LoanCalculatorApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LoanCalculatorApplication.class, args);
        LOG.info("Application started!");
    }
}
