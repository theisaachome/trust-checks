package com.highway.trustchecks.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "evidence_files")
public class EvidenceFile {
    @Id
    @GeneratedValue
    @Column(name = "evidence_id",columnDefinition = "UUID")
    private UUID evidenceId;
    @ManyToOne
    @JoinColumn(name = "case_id",nullable = false)
    private ScamCase scamCase;
    private String fileName;
    private String fileUrl;
    private String fileType;
}
