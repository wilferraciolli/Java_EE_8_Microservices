package com.acme.payments.api.models;

import com.acme.payments.api.models.db.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Transaction repository.
 */
public interface TransactionRepository extends JpaRepository<TransactionEntity, String> {
}
