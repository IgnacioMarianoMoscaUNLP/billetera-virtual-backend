package com.ignaciomariano.billetera.billetera_virtual_backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name="transactions")
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="origin_account",nullable=false)
    private Account originAccount;
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="destination_account",nullable=false)
    private Account destinationAccount;

    @Column(nullable = false)
    private String originCvu;
    @Column(nullable = false)
    private String destinationCvu;
    @Column(nullable = false)
    private float amount;
    @Column(nullable=false)
    private Timestamp createdAt;
    @Column(nullable=false)
    private Boolean status;
    @Column()
    private String comment;
}
