package com.highway.trustchecks.repos;
import com.highway.trustchecks.entity.CaseReporter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CaseReporterRepos extends JpaRepository<CaseReporter, UUID> {

    Optional<CaseReporter> findByContactEmail(String email);
}
