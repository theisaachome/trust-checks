package com.highway.trustchecks.repos;

import com.highway.trustchecks.entity.ScamCase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ScamCaseRepos extends JpaRepository<ScamCase, UUID> {
}
