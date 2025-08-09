package com.highway.trustchecks.api;

import com.highway.trustchecks.dto.ReportRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reports")
public class ReportsAPI {


    @PostMapping
    public ResponseEntity<String> createNewReport(@RequestBody ReportRequestDto data) {
        return  ResponseEntity.status(HttpStatus.CREATED).body("Created New Report");
    }

}
