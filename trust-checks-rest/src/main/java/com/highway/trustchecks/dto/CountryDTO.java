package com.highway.trustchecks.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CountryDTO(
        @JsonProperty("country_name") String countryName,
        @JsonProperty("country_code") String countryCode
) {
}
