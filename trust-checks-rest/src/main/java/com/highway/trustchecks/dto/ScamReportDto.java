package com.highway.trustchecks.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.highway.trustchecks.entity.CaseStatus;

import java.util.List;

public record ScamReportDto(
        ReporterDTO reporter,
        @JsonProperty("scammer_details") ScammerDetailsDTO scammerDetails,
        @JsonProperty("scam_information") ScamInformationDTO scamInformation,
        @JsonProperty("payment_information") PaymentInformationDTO paymentInformation,
        List<AttachmentDTO> evidence,
        CaseStatus status,
        List<String> tags,
        @JsonProperty("data_source") String dataSource,
        String notes
) {}

