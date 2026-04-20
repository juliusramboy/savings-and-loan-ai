package com.savingsandloan.savings_and_loan_ai.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserListPayments {
    private BigDecimal amountPaid;
    private LocalDateTime paymentDate;
}
