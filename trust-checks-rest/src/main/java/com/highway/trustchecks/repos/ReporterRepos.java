package com.highway.trustchecks.repos;
import com.highway.trustchecks.entity.Reporter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ReporterRepos extends JpaRepository<Reporter, UUID> {

    Optional<Reporter> findByContactEmail(String email);
}
