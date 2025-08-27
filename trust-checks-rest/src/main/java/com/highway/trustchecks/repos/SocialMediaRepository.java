package com.highway.trustchecks.repos;
import com.highway.trustchecks.entity.SocialMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface SocialMediaRepository extends JpaRepository<SocialMedia, UUID> {
}
