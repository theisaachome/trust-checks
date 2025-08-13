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
        name = "payment_transactions",
indexes = {
        @Index(name = "idx_bank_account_number", columnList = "bank_account_number"),
        @Index(name = "idx_bank_name", columnList = "bank_name"),
        @Index(name = "idx_transaction_date", columnList = "transaction_date")
    }
)
public class PaymentTransaction {

    @Id
    @GeneratedValue
    @Column(name = "transaction_id",columnDefinition = "UUID")
    private UUID transactionId;

    @ManyToOne
    @JoinColumn(name = "payment_information_id",nullable = false)
    private PaymentInformation paymentInformation;
    private String paymentMethod;
    private String accountHolderName;
    private String bankAccountNumber;
    private String bankName;
    private BigDecimal amount;
    private LocalDate transactionDate;

}
