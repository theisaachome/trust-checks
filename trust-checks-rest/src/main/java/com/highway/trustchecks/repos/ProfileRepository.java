package com.highway.trustchecks.repos;

import com.highway.trustchecks.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProfileRepository extends JpaRepository<Profile, UUID> {
    Optional<Profile> findByPhoneNumber(String phone);
}
