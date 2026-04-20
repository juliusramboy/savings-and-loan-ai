package com.savingsandloan.savings_and_loan_ai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SavingsAndLoanAiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SavingsAndLoanAiApplication.class, args);
	}

}
