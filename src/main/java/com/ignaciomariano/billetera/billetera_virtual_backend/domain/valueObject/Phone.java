package com.ignaciomariano.billetera.billetera_virtual_backend.domain.valueObject;

import java.util.Objects;

public class Phone {
    private final String number;
    private final String countryCode;

    private Phone(String number, String country) {
        if(!isValid(number, country))
            throw new IllegalArgumentException("Invalid phone number");
        this.number = number;
        this.countryCode = country;
    }

    public static Phone of(String countryCode, String rawNumber) {
        String normalized = rawNumber.replaceAll("\\D", ""); // deja solo dígitos
        return new Phone(countryCode, normalized);
    }
    public static boolean isValid(String countryCode, String number){
        if(countryCode == null || countryCode.isBlank())
            throw  new IllegalArgumentException("Country code cannot be null or blank");
        if(number == null || number.isBlank() )
            throw new IllegalArgumentException("Number cannot be null or blank");
        return true;
    }
    public String asE164() {
        return countryCode + number; // ej: "+541122334455"
    }
    public String getNumber(){ return number; }
    public String getCountryCode(){ return  countryCode; }


    @Override
    public String toString(){
        return asE164();
    }
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return number.equals(phone.number) && countryCode.equals(phone.countryCode);
    }
    @Override
    public int hashCode(){
        return Objects.hash(number, countryCode);
    }

}
