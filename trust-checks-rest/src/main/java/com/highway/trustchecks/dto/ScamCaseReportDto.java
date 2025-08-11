package com.highway.trustchecks.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.highway.trustchecks.entity.CaseStatus;

import java.util.List;

public record ScamCaseReportDto(
        ReporterDTO reporter,
        @JsonProperty("scammer_details") ScammerDetailsDTO scammerDetails,
        @JsonProperty("scam_case_information") ScamCaseInformationDTO scamInformation,
        @JsonProperty("payment_information") PaymentInformationDTO paymentInformation,
        CaseEvidenceDTO case_evidence,
        CaseStatus status,
        List<String> tags,
        @JsonProperty("data_source") String dataSource,
        String notes
) {}

