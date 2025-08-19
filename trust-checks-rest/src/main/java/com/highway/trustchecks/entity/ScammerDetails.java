package com.highway.trustchecks.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "scammer_details")
public class ScammerDetails {

    @Id
    @GeneratedValue
    @Column(name = "scammer_details_id",columnDefinition = "UUID")
    private UUID id;

    private String scammerAlias;
    private String fullName;
    private String phoneNumber;
    private String emailAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    private Location location;
    @JsonIgnore
    @OneToMany(mappedBy = "scammer",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SocialMediaHandle> socialMediaHandles = new ArrayList<>();

}
