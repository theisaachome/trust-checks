package com.highway.trustchecks.entity;

import com.highway.trustchecks.entity.ScamReport;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(schema = "trust_checks",name = "scammer_payment_methods")
public class ScammerPaymentMethod {
    @Id
    private Long id;
    private String accountNumber;
    private String providerName;
    private String accountHolderName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "scammer_report_id")
    private ScamReport scamReport;
    @ManyToOne
    @JoinColumn(name="method_type_id")
    private PaymentMethodType paymentMethodType;
}
