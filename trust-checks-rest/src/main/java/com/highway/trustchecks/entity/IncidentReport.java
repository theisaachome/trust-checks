package com.highway.trustchecks.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "scame_case_report")
public class IncidentReport {

    @Id
    @GeneratedValue
    @Column(name = "incident_report_id", unique = true, nullable = false,columnDefinition = "UUID")
    private UUID id;
    // many reports by a reporter
    @ManyToOne
    @JoinColumn(name = "reporter_id",nullable = false,unique = true,updatable = false)
    private Reporter reporter;
    //one scammerDetails can be found in  many reports
    @ManyToOne
    @JoinColumn(name = "profile_id",nullable = false,unique = true,updatable = false)
    private Profile profile;
    // case information

    // case evidence
    @OneToOne
    @JoinColumn(name = "evidence_id")
    private Evidence evidence;

    // case-information
    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "incident_id")
    private Incident incident;
    // payments
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "payment_id")
    private Set<Payment> paymentInformation;

    // tags
    @ManyToMany
    @JoinTable(
            name = "scam_case_report_tags",
            joinColumns = @JoinColumn(name = "report_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<CaseTag> caseTags = new ArrayList<>();
    // reporter-status
    @Enumerated(EnumType.STRING)
    private CaseStatus status;
    private String modality;
    // notes
    private String notes;
    // data-source
    private String dataSource;
    // reported_date (created-by-system)
    private LocalDateTime reportedDate;
    private boolean declarationConsent;
}
