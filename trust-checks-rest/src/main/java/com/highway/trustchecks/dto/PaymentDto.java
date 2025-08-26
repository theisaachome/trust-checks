package com.highway.trustchecks.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PaymentDto(
        @JsonProperty("payment_method") String paymentMethod,
        @JsonProperty("bank_name") String bankName,
        @JsonProperty("account_number") String account_number,
        @JsonProperty("account_holder_name") String accountHolderName,
        @JsonProperty("amount") BigDecimal amount,
        @JsonProperty("currency")String currency,
        @JsonProperty("transaction_date") LocalDate transactionDate
) {
}
