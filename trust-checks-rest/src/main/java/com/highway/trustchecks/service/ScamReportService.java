package com.highway.trustchecks.service;

import com.highway.trustchecks.dto.ScamReportDto;
import com.highway.trustchecks.entity.ScamCase;

public interface ScamReportService {

    ScamCase ingestScamReport(ScamReportDto dto);
}
