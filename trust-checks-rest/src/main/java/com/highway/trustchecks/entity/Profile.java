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
public class Profile {

    @Id
    @GeneratedValue
    @Column(name = "profile_id",columnDefinition = "UUID")
    private UUID id;

    private String alias;
    private String fullName;
    private String phoneNumber;
    private String emailAddress;

    @JsonIgnore
    @OneToMany(mappedBy = "profile",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SocialMedia> socialMedia = new ArrayList<>();


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    private Location location;

}
