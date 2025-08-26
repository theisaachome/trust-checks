package com.highway.trustchecks.repos;

import com.highway.trustchecks.entity.IncidentReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ScamCaseReportRepo extends JpaRepository<IncidentReport, UUID> {
}
