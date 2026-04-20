package com.savingsandloan.savings_and_loan_ai.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserFullLoanResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private Long applicationId;
    private BigDecimal balance;
    private List<UserListDueDates> dueDates;
    private List<UserListPayments> payments;


}
