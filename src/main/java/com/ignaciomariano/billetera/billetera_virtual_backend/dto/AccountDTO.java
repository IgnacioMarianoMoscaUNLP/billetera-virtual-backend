package com.ignaciomariano.billetera.billetera_virtual_backend.dto;

public record AccountDTO(String cvu, float balance, String currency, String accountHolder) {
}
