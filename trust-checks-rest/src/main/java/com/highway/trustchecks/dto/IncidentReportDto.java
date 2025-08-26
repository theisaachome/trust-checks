package com.highway.trustchecks.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.highway.trustchecks.entity.CaseStatus;

import java.util.List;

public record IncidentReportDto(
        @JsonProperty("profile") ProfileDto profile,
        ReporterDto reporter,
        @JsonProperty("incident") IncidentDto incident,
        String modality,
        List<String> tags,
        String notes,
        boolean declarationConsent
) {}

