package com.ignaciomariano.billetera.billetera_virtual_backend.domain.entity;


import com.ignaciomariano.billetera.billetera_virtual_backend.domain.valueObject.Money;
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
    private Money balance;

    //Relationship with user
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id",nullable=false)
    private User accountHolder;
}
