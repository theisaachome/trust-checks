package com.highway.trustchecks.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "reporters")
public class Reporter {

    @Id
    @GeneratedValue
    @Column(name = "reporter_id", unique = true, nullable = false,columnDefinition = "UUID")
    private UUID id;

    private String name;
    private String contactEmail;
    private String contactPhone;
}
