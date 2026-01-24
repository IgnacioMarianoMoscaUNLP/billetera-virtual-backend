package com.ignaciomariano.billetera.billetera_virtual_backend.model;

import java.sql.Timestamp;
import java.util.Date;

public class Transaction {

    private String originAccountId;
    private String destinationAccountId;
    private float amount;
    private Timestamp timestamp;
    private Boolean status;
    private String comment;
}
