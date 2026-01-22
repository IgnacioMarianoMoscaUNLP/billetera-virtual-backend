package com.ignaciomariano.billetera.billetera_virtual_backend.dto;

public record TransactionRequestDTO (String cvuDestination,float amount,String description){}
