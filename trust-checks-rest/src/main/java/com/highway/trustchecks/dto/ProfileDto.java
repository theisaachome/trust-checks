package com.highway.trustchecks.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ProfileDto(
        @JsonProperty("alias") String alias,
        @JsonProperty("full_name") String fullName,
        @JsonProperty("phone_number") String phoneNumber,
        @JsonProperty("email_address") String emailAddress,
        @JsonProperty("social_media") List<SocialMediaDto> socialMediaHandles,
        LocationDto location
) {
}
