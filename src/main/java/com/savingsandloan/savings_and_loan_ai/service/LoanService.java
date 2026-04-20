package com.savingsandloan.savings_and_loan_ai.service;

import com.savingsandloan.savings_and_loan_ai.dto.request.BorrowerNameRequest;
import com.savingsandloan.savings_and_loan_ai.dto.response.ApiResponse;
import com.savingsandloan.savings_and_loan_ai.dto.response.UserFullLoanResponse;
import com.savingsandloan.savings_and_loan_ai.feign.LoanInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class LoanService {
    private final LoanInterface loanInterface;
    private final ChatClient chatClient;

    public LoanService(LoanInterface loanInterface, ChatClient.Builder chatClientBuilder) {
        this.loanInterface = loanInterface;
        this.chatClient = chatClientBuilder.build();
    }


    public String getUserLoan(BorrowerNameRequest request){
        String promptFromUser = request.getFirstName() + "You are an assistant name miming that receives raw text. If the text contains a date written with numbers, rewrite it into a human‑readable format (e.g., '04/19/2026' → 'April 19, 2026'). If the text contains an amount of money, always format it as Philippine Peso (₱) without converting to USD or any other currency.Remove any technical objects or wrappers (e.g., ApiResponse, payloads, JSON classes). Always include in the answer the person's first name, last name, and application ID, along with the formatted details. After formatting, provide a brief answer of your answer in my question";
        String extractedName = filterRawData(request.getFirstName());
        System.out.println(extractedName);

        BorrowerNameRequest mergedData = new BorrowerNameRequest();
        mergedData.setFirstName(extractedName);
        mergedData.setInternalKey(request.getInternalKey());

        ApiResponse<UserFullLoanResponse> data = loanInterface.getSpecificUserLoan(mergedData);

        String loanDataAsString = data.toString();

        return chatClient
                .prompt()
                .system(promptFromUser)
                .user(loanDataAsString)
                .call()
                .content();
    }

    public String filterRawData(String question){
        String systemPrompt = "You are an assistant that receives raw text. If the text contains a person's name, extract and return only the name. Do not include any other words, explanations, or formatting—just the name itself.";

        return chatClient
                .prompt()
                .system(systemPrompt)
                .user(question)
                .call()
                .content();
    }


}
