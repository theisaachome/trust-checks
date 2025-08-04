package com.highway.trustchecks.entity;

import jakarta.persistence.*;

@Entity
@Table(schema = "trust_checks",name = "case_type")
public class CaseType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
