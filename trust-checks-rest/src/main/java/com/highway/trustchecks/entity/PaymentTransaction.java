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
@Table(name = "payment_transactions")
public class PaymentTransaction {

    @Id
    @GeneratedValue
    @Column(name = "transaction_id",columnDefinition = "UUID")
    private UUID transactionId;

    @ManyToOne
    @JoinColumn(name = "case_id",nullable = false)
    private ScamCase scamCase;

    private String paymentMethod;
    private String accountHolderName;
    private String bankAccountNumber;
    private String bankName;
    private BigDecimal amount;
    private String currency;
    private LocalDate transactionDate;

}
