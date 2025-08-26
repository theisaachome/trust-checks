package com.highway.trustchecks.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SocialMediaDto(
        String platform,
        @JsonProperty("profile_url") String profileUrl
) {
}
