package com.highway.trustchecks.repos;

import com.highway.trustchecks.entity.Incident;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ScamCaseInformationRepos extends JpaRepository<Incident, UUID> {
}
