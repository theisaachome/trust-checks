package com.highway.trustchecks.repos;

import com.highway.trustchecks.entity.ScammerDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ScammerDetailsRepos extends JpaRepository<ScammerDetails, UUID> {
    Optional<ScammerDetails> findByPhoneNumber(String phone);
}
