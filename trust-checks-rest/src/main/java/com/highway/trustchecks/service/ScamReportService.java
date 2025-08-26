package com.highway.trustchecks.service;

import com.highway.trustchecks.api.ApiResponse;
import com.highway.trustchecks.api.IdResponse;
import com.highway.trustchecks.dto.IncidentReportDto;

public interface ScamReportService {

    ApiResponse<IdResponse> ingestScamReport(IncidentReportDto dto);
}
