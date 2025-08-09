package com.highway.trustchecks.service.impl;

import com.highway.trustchecks.entity.Report;
import com.highway.trustchecks.service.ReportsService;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportsService {
    @Override
    public Report createReport(Report report) {
        // create report instance

        var newReport = new Report();

        return null;
    }
}
