package com.ignaciomariano.billetera.billetera_virtual_backend.domain.repository;

import com.ignaciomariano.billetera.billetera_virtual_backend.domain.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
