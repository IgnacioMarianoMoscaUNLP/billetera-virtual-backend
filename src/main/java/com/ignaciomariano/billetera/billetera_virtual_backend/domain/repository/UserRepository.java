package com.ignaciomariano.billetera.billetera_virtual_backend.domain.repository;

import com.ignaciomariano.billetera.billetera_virtual_backend.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
