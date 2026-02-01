package com.ignaciomariano.billetera.billetera_virtual_backend.domain.valueObject;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Objects;

public class EncryptedPassword {
    private final String hash;

    private EncryptedPassword(String hash) {
        if(hash == null || hash.isBlank())
            throw new IllegalArgumentException("Hash cannot be null or blank");
        this.hash = hash;
    }

    public static EncryptedPassword of(String plainPassword){
     if(plainPassword == null || plainPassword.isBlank())
         throw new IllegalArgumentException("Password cannot be null or blank");
     String hash = passwordHasher(plainPassword);
     return new EncryptedPassword(hash);
    }

    public boolean matches(String plainPassword) {
        if (plainPassword == null || plainPassword.isBlank()) {
            return false;
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(plainPassword, this.hash);
    }

    private static String passwordHasher(String plainPassword){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hash = encoder.encode(plainPassword);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EncryptedPassword)) return false;
        EncryptedPassword that = (EncryptedPassword) o;
        return hash.equals(that.hash);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hash);
    }

    @Override
    public String toString() {
        return hash;
    }


}
