package com.highway.trustchecks.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "scammer_social_handles")
public class SocialMediaHandle {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "UUID", nullable = false, updatable = false,name = "handle_id")
    private UUID id;

    private String platform;
    private String profileUrl;

    @ManyToOne
    @JoinColumn(name = "scammer_id",nullable = false)
    private Scammer scammer;
}
