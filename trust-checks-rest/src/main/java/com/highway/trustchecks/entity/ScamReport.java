package com.highway.trustchecks.entity;
import com.highway.trustchecks.entity.ReportStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "scam_reports",schema = "trust_checks")
public class ScamReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String scammerAlias;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private double amountLost;
    @Column(columnDefinition = "TEXT",nullable = false)
    private String scamDescription;

    @ManyToOne
    @JoinColumn(name = "country_id_fk")
    private Country country;
    @ManyToOne
    @JoinColumn(name = "city_id_fk")
    private City city;
    @OneToOne
    @JoinColumn(name = "case_type_id_fk")
    private CaseType caseType;
    private ReportStatus status;




}
