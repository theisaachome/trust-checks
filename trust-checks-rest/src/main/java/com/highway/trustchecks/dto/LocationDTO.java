package com.highway.trustchecks.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LocationDTO(
        @JsonProperty("country_name") String countryName,
        @JsonProperty("country_code") String countryCode,
        @JsonProperty("city_name") String cityName
) {
}
