package com.ignaciomariano.billetera.billetera_virtual_backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.service.annotation.GetExchange;

@Entity(name="user")
@Table(name="users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private Long id;

    @Column(name="dniNumber",nullable=false,unique=true,updatable=false)
    private int dniNumber;
    @Column(name = "firstName",nullable=false)
    private String firstName;
    @Column(name = "lastName",nullable=false)
    private String lastName;
    @Column(name = "email",nullable=false,unique=true)
    private String email;
    @Column(name = "password",nullable=false)
    private String password;
    @Column(name = "status",nullable=false)
    private String status;
}
