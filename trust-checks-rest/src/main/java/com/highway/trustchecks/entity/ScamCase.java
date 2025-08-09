package com.highway.trustchecks.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

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

    private String name;
}
