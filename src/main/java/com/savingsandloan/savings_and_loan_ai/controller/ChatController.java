package com.savingsandloan.savings_and_loan_ai.controller;

import com.savingsandloan.savings_and_loan_ai.dto.request.BorrowerNameRequest;
import com.savingsandloan.savings_and_loan_ai.dto.response.ApiResponse;
import com.savingsandloan.savings_and_loan_ai.dto.response.UserFullLoanResponse;
import com.savingsandloan.savings_and_loan_ai.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/chat")
@RequiredArgsConstructor
public class ChatController {

    private final LoanService loanService;

    @PostMapping("/cred")
    public String getData(@RequestBody BorrowerNameRequest request){
        return loanService.getUserLoan(request);
    }

//    @PostMapping("/ask")
//    public ApiResponse<UserFullLoanResponse> askGrock(@RequestBody BorrowerNameRequest request){
//        return loanService.getUserLoan(request);
//    }

}
