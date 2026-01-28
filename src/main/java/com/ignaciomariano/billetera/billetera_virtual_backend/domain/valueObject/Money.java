package com.ignaciomariano.billetera.billetera_virtual_backend.domain.valueObject;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;


@Getter
@Setter
public class Money {

    private final BigDecimal amount;
    private final Currency currency;


    private Money(BigDecimal amount, Currency currency) {
        Objects.requireNonNull(amount,"The amount can not be null");
        Objects.requireNonNull(currency,"The currency can not be null");
        this.currency = currency;
        validateAmount(amount);
        this.amount = amount;
    }

    // --- Static Factory Methods
    // most common for Money pattern implementations
    public static Money of(BigDecimal amount, String currencyCode){
        return new Money(amount, Currency.getInstance(currencyCode));
    }
    // for zero amount
    public static Money zero(String currencyCode){
        return new Money(BigDecimal.ZERO, Currency.getInstance(currencyCode));
    }


    public Money add(Money other){
        validateCurrency(other);
        return new Money(amount.add(other.amount), currency);
    }

    private void validateCurrency(Money other){
        if(!this.currency.equals(other.currency)){
            throw new IllegalArgumentException("Currencies do not match");
        }
    }

    public Money subtract(Money other){
        validateCurrency(other);
        return new Money(this.amount.subtract(other.amount), currency);
    }

    public Money multiply(int factor){

        if(factor < 0 || factor > 100){
            throw new IllegalArgumentException("Factor must be between 0 and 100");
        }
        return new Money(amount.multiply(BigDecimal.valueOf(factor).divide(BigDecimal.valueOf(100))), currency);
    }

    private void validateAmount(BigDecimal amount){
        if(amount.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("Amount can not be negative");
        }
        if(amount.scale() > this.currency.getDefaultFractionDigits()){
            throw new IllegalArgumentException("Amount can not have more than " + this.currency.getDefaultFractionDigits() + " decimal places fot the currency "+ this.currency.getCurrencyCode());
        }
    }
    @Override
    public String toString(){
        return String.format("%.2f %s", currency.getCurrencyCode(),amount);
    }

    public boolean isZero(){
        return amount.compareTo(BigDecimal.ZERO) == 0;
    }
    // compareTo methods
    public boolean isGreaterThan(Money other){
        validateCurrency(other);
        return amount.compareTo(other.amount) > 0;
    }
    public boolean isLessThan(Money other){
        validateCurrency(other);
        return amount.compareTo(other.amount) < 0;
    }
    public boolean isNegative(){
        return amount.compareTo(BigDecimal.ZERO) < 0;
    }
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount.compareTo(money.amount) == 0 && Objects.equals(currency, money.currency);
    }
    @Override
    public int hashCode(){
        return Objects.hash(amount, currency);
    }
}
