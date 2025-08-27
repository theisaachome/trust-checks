package com.highway.trustchecks.repos;

import com.highway.trustchecks.entity.Evidence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EvidenceRepository extends JpaRepository<Evidence, UUID> {
}
