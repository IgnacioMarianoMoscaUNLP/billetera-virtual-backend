package com.ignaciomariano.billetera.billetera_virtual_backend.domain.repository;

import com.ignaciomariano.billetera.billetera_virtual_backend.domain.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}
