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
@Table(name = "incidents")
public class Incident {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "UUID", nullable = false, updatable = false,name = "incident_id")
    private UUID id;
    private String category;
    private String type;
    private LocalDate dateOfIncident;
    private String shortStory;
    private String longStory;
}
