package com.ignaciomariano.billetera.billetera_virtual_backend.repository;

import com.ignaciomariano.billetera.billetera_virtual_backend.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
