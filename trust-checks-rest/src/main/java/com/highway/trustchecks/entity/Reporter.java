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
    @Column(name = "nick_name")
    private String nickName;
    @Column(name="contact_email")
    private String contactEmail;
    @Column(name="contact_phone")
    private String contactPhone;

}
