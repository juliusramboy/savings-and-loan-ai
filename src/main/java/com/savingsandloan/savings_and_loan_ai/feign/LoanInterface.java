package com.savingsandloan.savings_and_loan_ai.feign;

import com.savingsandloan.savings_and_loan_ai.dto.request.BorrowerNameRequest;
import com.savingsandloan.savings_and_loan_ai.dto.response.ApiResponse;
import com.savingsandloan.savings_and_loan_ai.dto.response.UserFullLoanResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="loan", url ="${project-a.url}")
public interface LoanInterface {

    @PostMapping("/api/admin/loan/user-loan")
    ApiResponse<UserFullLoanResponse> getSpecificUserLoan(@RequestBody BorrowerNameRequest request);
}
