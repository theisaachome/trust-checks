package com.highway.trustchecks.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "profile_identifiers")
public class ProfileIdentifier {

    @Id
    @GeneratedValue
    @Column(name = "id", columnDefinition = "UUID", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;
    @Column(name = "type",nullable = false,length = 50)
    private String type;  // -- e.g. BANK_ACCOUNT, EMAIL, PHONE, SOCIAL_MEDIA
    @Column(name="value",nullable = false)
    private String value;  // -- raw value (e.g. bank number, email, phone) 1234-1233-1232
    @Column(name = "normalized_value")
    private String normalizedValue;  // cleaned/standardized version 123412331232


    @Column(name = "metadata", columnDefinition = "jsonb")
    private String metadata;  // -- e.g. bank_name, account_holder_name


    private String accountHolderName;
    private String accountNumber;
    private String bankName;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt = Instant.now();
}
