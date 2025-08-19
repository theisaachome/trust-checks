package com.highway.trustchecks.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;


@Getter
@Setter
@Entity
@Table(name = "scam_case_tag")
public class ScamCaseTag {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "UUID",name = "tag_id")
    private UUID tagId;
    @JsonIgnore
    @ManyToOne
    private ScamCaseInformation scameCaseInformation;
    private String tag;
}
