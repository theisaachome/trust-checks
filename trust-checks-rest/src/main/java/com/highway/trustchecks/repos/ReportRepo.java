package com.highway.trustchecks.repos;

import com.highway.trustchecks.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepo extends JpaRepository<Report, Long> {
}
