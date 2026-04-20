package com.savingsandloan.savings_and_loan_ai.dto.response;

import com.savingsandloan.savings_and_loan_ai.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserListDueDates {
    private LocalDate dueDate;
    private BigDecimal payment;
    private Status status;
}
