package com.highway.trustchecks.api;

import com.highway.trustchecks.dto.IncidentReportDto;
import com.highway.trustchecks.service.IncidentReportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resources/v1/incident-reports")
public class IncidentReportsController {

/*
    GET    /api/incident-reports          → list all reports (with pagination & filters)
    POST   /api/incident-reports          → create a new report
    GET    /api/incident-reports/{id}     → get details of a single report
    PATCH  /api/incident-reports/{id}     → update status/notes (not reporter data)
    DELETE /api/incident-reports/{id}     → soft delete/archive a report

 */

    private final IncidentReportService incidentReportService;

    public IncidentReportsController(IncidentReportService incidentReportService) {
        this.incidentReportService = incidentReportService;
    }


    @GetMapping
    public ResponseEntity<String> getAllReports() {
        return ResponseEntity.status(HttpStatus.OK).body("All Reports");
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createNewReport(@RequestBody IncidentReportDto data) {
        var result = incidentReportService.ingestIncidentReport(data);
        return  ResponseEntity.status(HttpStatus.CREATED).body(result);
    }


}
