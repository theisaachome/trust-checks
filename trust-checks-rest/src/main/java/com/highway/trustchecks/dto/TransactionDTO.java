package com.highway.trustchecks.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TransactionDTO(
        @JsonProperty("payment_method") String paymentMethod,
        @JsonProperty("account_holder_name") String accountHolderName,
        @JsonProperty("bank_account_number") String bankAccountNumber,
        @JsonProperty("bank_name") String bankName,
        BigDecimal amount,
        @JsonProperty("transaction_date") LocalDate transactionDate
) {
}
