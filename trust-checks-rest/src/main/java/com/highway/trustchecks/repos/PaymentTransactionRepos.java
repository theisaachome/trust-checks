package com.highway.trustchecks.repos;

import com.highway.trustchecks.entity.PaymentTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentTransactionRepos extends JpaRepository<PaymentTransaction, UUID> {
}
