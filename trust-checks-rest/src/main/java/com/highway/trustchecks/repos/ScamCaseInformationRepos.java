package com.highway.trustchecks.repos;

import com.highway.trustchecks.entity.ScamCaseInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ScamCaseInformationRepos extends JpaRepository<ScamCaseInformation, UUID> {
}
