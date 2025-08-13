package com.highway.trustchecks.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "scame_case_report")
public class ScamCaseReport {

    @Id
    @GeneratedValue
    @Column(name = "scame_case_report_id", unique = true, nullable = false,columnDefinition = "UUID")
    private UUID scamCaseReportId;
    // reporter
    @OneToOne
    @JoinColumn(name = "reporter_id",nullable = false,unique = true,updatable = false)
    private CaseReporter caseReporter;
    // scammerDetails
    @OneToOne
    @JoinColumn(name = "scammer_id",nullable = false,unique = true,updatable = false)
    private ScammerDetails scammerDetails;
    // case information

    // case evidence
    @OneToOne
    @JoinColumn(name = "case_evidence_id")
    private CaseEvidence caseEvidence;

    // case-information
    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "scam_case_information_id")
    private ScamCaseInformation scamCaseInformation;
    // payment-information
    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "payment_information_id")
    private PaymentInformation paymentInformation;
    // tags
    @OneToMany(cascade =  CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "report_id")
    private List<ScamCaseTag> scamCaseTags = new ArrayList<>();
    // reporter-status
    @Enumerated(EnumType.STRING)
    private CaseStatus status;
    // notes
    private String notes;
    // data-source
    private String dataSource;
    // reported_date (created-by-system)
    private LocalDateTime reportedDate;
}
