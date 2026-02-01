package com.ignaciomariano.billetera.billetera_virtual_backend.domain.valueObject;

import java.util.UUID;



public class UserId {
    private final UUID value;

    private UserId(UUID id) {
        if(id==null) throw new IllegalArgumentException("User id cannot be null");
        this.value = id;
    }

    public UUID asUuid() {
        return value;
    }

    @Override
    public String toString(){
        return value.toString();
    }

    public static UserId of(UUID id){
        return new UserId(id);
    }
    // Creación de un UserId a partir de un String
    // Muy útil cuando recibimos IDs  API o desde la BD
    public static UserId fromString(String raw) {
        if (raw == null || raw.isBlank()) {
            throw new IllegalArgumentException("User id cannot be null or blank");
        }
        return new UserId(UUID.fromString(raw));
    }


    public static UserId generate() {
        return new UserId(UUID.randomUUID());
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        UserId userId = (UserId) o;
        return value.equals(userId.value);
    }
    @Override
    public int hashCode(){
        return value.hashCode();
    }

}
