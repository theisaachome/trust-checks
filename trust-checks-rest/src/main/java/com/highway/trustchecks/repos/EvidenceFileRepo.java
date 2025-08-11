package com.highway.trustchecks.repos;

import com.highway.trustchecks.entity.EvidenceFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EvidenceFileRepo extends JpaRepository<EvidenceFile, UUID> {
}
