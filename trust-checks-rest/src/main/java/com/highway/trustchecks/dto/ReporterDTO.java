package com.highway.trustchecks.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ReporterDTO(
        @JsonProperty("name") String name,
        @JsonProperty("contact_email") String contactEmail,
        @JsonProperty("contact_phone") String contactPhone
) {
}
