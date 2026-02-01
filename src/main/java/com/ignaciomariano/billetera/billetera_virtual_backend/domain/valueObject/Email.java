package com.ignaciomariano.billetera.billetera_virtual_backend.domain.valueObject;

import java.util.regex.Pattern;

public class Email {

    //este es un patron para saber como es un mail
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@([A-Za-z0-9.-]+\\.[A-Za-z]{2,})$");

    private final String value;

    private Email(String value){
        if(!isValid(value))
            throw new IllegalArgumentException("Invalid email format: ");
        this.value = value.toLowerCase();
    }

    private static boolean isValid(String email) {
        return email != null && !email.isBlank() && EMAIL_PATTERN.matcher(email).matches();
    }

    public static Email of(String value){
        return new Email(value);
    }

    @Override
    public String toString(){
        return value;
    }
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return value.equals(email.value);
    }
    @Override
    public int hashCode(){
        return value.hashCode();
    }

}
