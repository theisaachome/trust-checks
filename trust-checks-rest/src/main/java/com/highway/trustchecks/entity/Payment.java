package com.highway.trustchecks.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(
        name = "payments",
indexes = {
        @Index(name = "idx_bank_account_number", columnList = "bank_account_number"),
        @Index(name = "idx_bank_name", columnList = "bank_name"),
        @Index(name = "idx_transaction_date", columnList = "transaction_date")
    }
)
public class Payment {

    @Id
    @GeneratedValue
    @Column(name = "transaction_id",columnDefinition = "UUID")
    private UUID transactionId;
    private String paymentMethod;
    private BigDecimal amount;
    private String currency;
    private LocalDate transactionDate;

}
