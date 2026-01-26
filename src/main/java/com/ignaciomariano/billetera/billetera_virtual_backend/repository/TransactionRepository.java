package com.ignaciomariano.billetera.billetera_virtual_backend.repository;

import com.ignaciomariano.billetera.billetera_virtual_backend.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
