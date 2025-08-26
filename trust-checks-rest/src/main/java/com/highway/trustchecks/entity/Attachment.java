package com.highway.trustchecks.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "attachments")
public class Attachment {

    @Id
    @GeneratedValue
    @Column(name = "attachment_id",columnDefinition = "UUID")
    private UUID id;
    private String fileName;
    private String fileUrl;
    private String fileType;

    @ManyToOne
    @JoinColumn(name = "case_evidence_id",nullable = false)
    private Evidence evidence;
}
