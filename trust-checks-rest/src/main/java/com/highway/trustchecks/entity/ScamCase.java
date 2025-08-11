package com.highway.trustchecks.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "scam_cases")
public class ScamCase {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "UUID", nullable = false, updatable = false,name = "case_id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "scammer_id",nullable = false)
    private Scammer scammer;

    @ManyToOne
    @JoinColumn(name = "reporter_id")
    private Reporter reporter;
    private String caseType;
    private String scamDescription;
    private String scamCategory;
    private String modality;
    private LocalDate dateOfIncident;
    private LocalDateTime reportedAt;
    @Enumerated(EnumType.STRING)
    private CaseStatus status;
    private String dataSource;
    private String notes;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "scamCase")
    private Set<EvidenceFile> evidenceFiles = new HashSet<>();
    @OneToMany(mappedBy = "scamCase")
    private Set<ScamCaseTag> scamCaseTags = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,mappedBy = "scamCase")
    private Set<PaymentTransaction> paymentTransactions = new HashSet<>();
}
