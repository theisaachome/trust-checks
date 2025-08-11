package com.highway.trustchecks.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SocialMediaHandleDTO(
        String platform,
        @JsonProperty("profile_url") String profileUrl
) {
}
