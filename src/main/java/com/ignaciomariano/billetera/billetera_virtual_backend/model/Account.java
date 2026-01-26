package com.ignaciomariano.billetera.billetera_virtual_backend.model;


import jakarta.persistence.*;
import lombok.*;

@Entity(name="account")
@Table(name="accounts")
@Getter @Setter
public class Account {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String cvu;
    @Column(nullable=false)
    private float balance;
    @Column(nullable=false)
    private String currency;

    //Relationship with user
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id",nullable=false)
    private User accountHolder;
}
