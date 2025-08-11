package com.highway.trustchecks.repos;

import com.highway.trustchecks.entity.Scammer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ScammerRepos extends JpaRepository<Scammer, UUID> {
    Optional<Scammer> findByPhoneNumber(String phone);
}
