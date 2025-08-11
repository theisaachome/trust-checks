package com.highway.trustchecks.repos;
import com.highway.trustchecks.entity.SocialMediaHandle;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface SocialMediaHandleRepo extends JpaRepository<SocialMediaHandle, UUID> {
}
