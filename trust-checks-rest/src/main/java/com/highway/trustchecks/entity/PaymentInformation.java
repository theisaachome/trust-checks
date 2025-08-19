package com.highway.trustchecks.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "payment_information")
public class PaymentInformation {

    @Id
    @GeneratedValue
    @Column(name = "payment_information_id", unique = true, nullable = false,columnDefinition = "UUID")
    private UUID paymentInformationId;


    @Column(name = "total_amount_lost")
    private BigDecimal totalAmountLost;
    private String currency;
//    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "paymentInformation")
    private Set<PaymentTransaction> paymentTransaction;
}
