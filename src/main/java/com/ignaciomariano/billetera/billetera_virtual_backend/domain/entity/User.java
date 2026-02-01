package com.ignaciomariano.billetera.billetera_virtual_backend.domain.entity;

import com.ignaciomariano.billetera.billetera_virtual_backend.domain.valueObject.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.ignaciomariano.billetera.billetera_virtual_backend.domain.valueObject.Email;

import javax.crypto.EncryptedPrivateKeyInfo;
import java.time.LocalDate;


public class User {


    private final UserId id;
    private int dniNumber;
    private Phone phone;
    private String firstName;
    private String lastName;
    private Email email;
    private EncryptedPassword password;
    private String status;
    private LocalDate dateOfBirth;


    private User(UserId id, int dniNumber, String firstName, String lastName, Email email, EncryptedPassword password, String status,Phone phone,LocalDate dateOfBirth) {
        this.id = id;
        this.dniNumber = dniNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.status = status;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
    }
    public static User create(int dniNumber, String firstName, String lastName, String email, String password,String countryCode,String number,LocalDate dateOfBirth){
        if(!isAdult(dateOfBirth))
            throw new IllegalArgumentException("User must be at least 18 years old");

        return new User(UserId.generate(), dniNumber, firstName, lastName, Email.of(email), EncryptedPassword.of(password), "ACTIVE",Phone.of(countryCode,number),dateOfBirth);
    }

    private static boolean isAdult(LocalDate dateOfBirth){
        LocalDate today = LocalDate.now();
        return today.isAfter(dateOfBirth.plusYears(18));
    }

}
