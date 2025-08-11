package com.highway.trustchecks.repos;

import com.highway.trustchecks.entity.ScamCaseReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ScamCaseReportRepo extends JpaRepository<ScamCaseReport, UUID> {
}
