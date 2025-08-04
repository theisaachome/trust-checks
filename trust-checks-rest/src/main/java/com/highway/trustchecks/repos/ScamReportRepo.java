package com.highway.trustchecks.repos;

import com.highway.trustchecks.entity.ScamReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScamReportRepo extends JpaRepository<ScamReport, Long> {
}
