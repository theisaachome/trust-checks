package com.highway.trustchecks.service;

import com.highway.trustchecks.BaseUnitObject;
import com.highway.trustchecks.dto.*;
import com.highway.trustchecks.entity.CaseStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class IncidentReportServiceTest extends BaseUnitObject {

    @Autowired
    private IncidentReportService incidentReportService;
    IncidentReportDto incidentReportDto;
    @BeforeEach
    void init(){


        this. incidentReportDto = new IncidentReportDto(
                createProfileDto(),
                createReporterDTO(),
                getIncidentDto(),
                "Online..",
                List.of("Job hunting","Online"),
                "User Submission",
                true
        );
    }

    @Test
    void shouldCreatePaymentInformationDto(){
        createPaymentInformationDTO();
    }

    @Test
    @DisplayName("test_new_incident_report")
    void testCreateNewIncidentReport(){
        var result = incidentReportService.ingestIncidentReport(incidentReportDto);
        assertNotNull(result);
    }
}
