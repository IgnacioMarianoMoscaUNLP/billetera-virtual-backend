package com.ignaciomariano.billetera.billetera_virtual_backend.domain.entity;


import com.ignaciomariano.billetera.billetera_virtual_backend.domain.valueObject.Money;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

public class Account {

    private String id;

    private String cvu;

    private Money balance;

    private User accountHolder;
}
