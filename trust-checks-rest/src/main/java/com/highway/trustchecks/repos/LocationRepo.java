package com.highway.trustchecks.repos;
import com.highway.trustchecks.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LocationRepo extends JpaRepository<Location, UUID> {
}
