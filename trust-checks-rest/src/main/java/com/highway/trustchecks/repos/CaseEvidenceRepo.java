package com.highway.trustchecks.repos;

import com.highway.trustchecks.entity.CaseEvidence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CaseEvidenceRepo extends JpaRepository<CaseEvidence, UUID> {
}
