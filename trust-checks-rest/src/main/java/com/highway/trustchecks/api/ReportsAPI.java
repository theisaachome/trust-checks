package com.highway.trustchecks.api;

import com.highway.trustchecks.dto.ScamCaseReportDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resources/v1/scam-reports")
public class ReportsAPI {


    @PostMapping
    public ResponseEntity<String> createNewReport(@RequestBody ScamCaseReportDto data) {
        return  ResponseEntity.status(HttpStatus.CREATED).body("Created New Report");
    }

    @GetMapping
    public ResponseEntity<String> getAllReports() {
        return ResponseEntity.status(HttpStatus.OK).body("All Reports");
    }

}
