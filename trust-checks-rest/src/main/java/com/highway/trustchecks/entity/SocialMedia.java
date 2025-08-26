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
@Table(name = "social_medias")
public class SocialMedia {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "UUID", nullable = false, updatable = false,name = "social_media_id")
    private UUID id;

    private String platform;
    private String profileUrl;

    @ManyToOne
    @JoinColumn(name = "profile_id",nullable = false)
    private Profile profile;
}
