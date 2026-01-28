package com.ignaciomariano.billetera.billetera_virtual_backend.application.dto;

public record TransactionRequestDTO (String cvuDestination,float amount,String description){}
