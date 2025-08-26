package com.highway.trustchecks.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

public record IncidentDto(

        @JsonProperty("category") String category,
        @JsonProperty("type") String type,
        @JsonProperty("date_of_incident") LocalDate dateOfIncident,
        String short_story,
        String details_story,
        EvidenceDto evidence,
        List<PaymentDto> payments
) {
}
