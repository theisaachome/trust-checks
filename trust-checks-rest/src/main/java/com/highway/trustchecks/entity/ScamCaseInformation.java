package com.highway.trustchecks.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "scam_case_information")
public class ScamCaseInformation {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "UUID", nullable = false, updatable = false,name = "case_id")
    private UUID caseId;
    private String caseType;
    private String scamDescription;
    private String scamCategory;
    private String modality;
    private LocalDate dateOfIncident;

}
