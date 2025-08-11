package com.highway.trustchecks.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ScammerDetailsDTO(
        @JsonProperty("scammer_alias") String scammerAlias,
        @JsonProperty("full_name") String fullName,
        @JsonProperty("phone_number") String phoneNumber,
        @JsonProperty("email_address") String emailAddress,
        @JsonProperty("social_media_handles") List<SocialMediaHandleDTO> socialMediaHandles,
        CountryDTO country,
        CityDTO city
) {
}
