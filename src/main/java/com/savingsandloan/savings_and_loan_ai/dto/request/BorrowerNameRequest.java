package com.savingsandloan.savings_and_loan_ai.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrowerNameRequest {
    private String firstName;
    private String internalKey;
}
