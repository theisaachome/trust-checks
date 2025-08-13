package com.highway.trustchecks.service;

import com.highway.trustchecks.dto.ScamCaseReportDto;
import com.highway.trustchecks.entity.ScamCaseInformation;
import com.highway.trustchecks.entity.ScamCaseReport;

public interface ScamReportService {

    ScamCaseReport ingestScamReport(ScamCaseReportDto dto);
}
