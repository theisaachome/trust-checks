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
@Table(name = "case_evidence")
public class Evidence {
    @Id
    @GeneratedValue
    @Column(name = "case_evidence_id",columnDefinition = "UUID")
    private UUID id;

    private String link;

}
