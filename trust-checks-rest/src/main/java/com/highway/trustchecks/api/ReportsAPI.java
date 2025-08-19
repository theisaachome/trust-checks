package com.highway.trustchecks.api;

import com.highway.trustchecks.dto.ScamCaseReportDto;
import com.highway.trustchecks.entity.ScamCaseReport;
import com.highway.trustchecks.service.ScamReportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resources/v1/scam-reports")
public class ReportsAPI {

    private final ScamReportService scamReportService;

    public ReportsAPI(ScamReportService scamReportService) {
        this.scamReportService = scamReportService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createNewReport(@RequestBody ScamCaseReportDto data) {
        var result = scamReportService.ingestScamReport(data);
        return  ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping
    public ResponseEntity<String> getAllReports() {
        return ResponseEntity.status(HttpStatus.OK).body("All Reports");
    }

}
