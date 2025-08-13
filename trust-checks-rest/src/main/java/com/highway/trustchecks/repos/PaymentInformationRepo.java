package com.highway.trustchecks.repos;

import com.highway.trustchecks.entity.PaymentInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface PaymentInformationRepo extends JpaRepository<PaymentInformation, UUID> {
}
