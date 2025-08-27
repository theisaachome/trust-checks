package com.highway.trustchecks.service;

import com.highway.trustchecks.api.ApiResponse;
import com.highway.trustchecks.api.IdResponse;
import com.highway.trustchecks.dto.IncidentReportDto;
import com.highway.trustchecks.dto.ProfileDto;

public interface IncidentReportService {

    ApiResponse<IdResponse> ingestIncidentReport(IncidentReportDto dto);
     void findIncidentReportsByProfileId(ProfileDto profileDto);
}
