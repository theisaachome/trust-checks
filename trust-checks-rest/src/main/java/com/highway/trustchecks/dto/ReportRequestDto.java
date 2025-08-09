package com.highway.trustchecks.dto;

public record ReportRequestDto(
        String alias,
        String phoneNumber,
        double amountLost,
        String description,
        CountryDTO country,
        String city,
        String caseType
) {
}

record CountryDTO(
        String name,
        String iso_code
){}

record CityDTO(String name){}
record CaseType(String name){}
