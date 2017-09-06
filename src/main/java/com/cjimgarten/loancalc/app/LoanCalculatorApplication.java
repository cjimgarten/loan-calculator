package com.cjimgarten.loancalc.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by chris on 9/2/17.
 */
@SpringBootApplication(scanBasePackages = "com.cjimgarten.loancalc")
public class LoanCalculatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoanCalculatorApplication.class, args);
    }
}
