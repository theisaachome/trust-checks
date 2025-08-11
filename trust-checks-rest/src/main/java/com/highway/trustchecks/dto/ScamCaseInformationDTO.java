package com.highway.trustchecks.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record ScamCaseInformationDTO(
        @JsonProperty("case_type") String caseType,
        @JsonProperty("scam_description") String scamDescription,
        @JsonProperty("scam_category") String scamCategory,
        String modality,
        @JsonProperty("date_of_incident") LocalDate dateOfIncident
) {
}
