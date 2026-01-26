package com.ignaciomariano.billetera.billetera_virtual_backend.repository;

import com.ignaciomariano.billetera.billetera_virtual_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
