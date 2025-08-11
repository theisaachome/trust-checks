package com.highway.trustchecks.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CityDTO(
        @JsonProperty("city_name") String cityName
) {
}
