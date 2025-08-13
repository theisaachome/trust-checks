package com.highway.trustchecks.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(
        name = "locations",
        indexes = {
                @Index(name = "idx_country_code",columnList = "country_code"),
                @Index(name="idx_city_name",columnList = "city_name")
        }
)
public class Location {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "UUID", nullable = false, updatable = false,name = "location_id")
    private UUID locationId;

    @Column(name = "country_name", nullable = false)
    private String countryName;

    @Column(name = "country_code", nullable = false, length = 2)
    private String countryCode;

    @Column(name = "city_name")
    private String cityName;

}
