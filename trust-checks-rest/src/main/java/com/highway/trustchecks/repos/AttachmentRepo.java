package com.highway.trustchecks.repos;
import com.highway.trustchecks.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface AttachmentRepo extends JpaRepository<Attachment, UUID> {
}
