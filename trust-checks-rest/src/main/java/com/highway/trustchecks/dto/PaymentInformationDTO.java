package com.highway.trustchecks.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;

public record PaymentInformationDTO(
        @JsonProperty("total_amount_lost") BigDecimal totalAmountLost,
        String currency,
        List<TransactionDTO> transactions
) {
}
