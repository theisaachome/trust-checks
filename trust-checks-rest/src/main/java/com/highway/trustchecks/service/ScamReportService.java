package com.highway.trustchecks.service;

import com.highway.trustchecks.api.ApiResponse;
import com.highway.trustchecks.api.IdResponse;
import com.highway.trustchecks.dto.ScamCaseReportDto;
import com.highway.trustchecks.entity.ScamCaseInformation;
import com.highway.trustchecks.entity.ScamCaseReport;

public interface ScamReportService {

    ApiResponse<IdResponse> ingestScamReport(ScamCaseReportDto dto);
}
