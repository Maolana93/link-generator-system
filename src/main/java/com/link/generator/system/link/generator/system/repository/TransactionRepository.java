package com.link.generator.system.link.generator.system.repository;


import com.link.generator.system.link.generator.system.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    boolean existsByInvoiceNumber(String invoiceNumber);
    Optional<Transaction> findByInvoiceNumber (String invoiceNumber);

}
