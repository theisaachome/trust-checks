package com.highway.trustchecks.entity;
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
@Table(name = "scammers")
public class Scammer {

    @Id
    @GeneratedValue
    @Column(name = "scammer_id",columnDefinition = "UUID")
    private UUID id;

    private String scammerAlias;
    private String fullName;
    private String phoneNumber;
    private String emailAddress;
    private String countryName;
    private String countryCode;
    private String cityName;

    @OneToMany(mappedBy = "scammer",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SocialMediaHandle> socialMediaHandles = new ArrayList<>();

}
