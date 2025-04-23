package com.jpa.tpHeritage.exo1;

import jakarta.persistence.Entity;

@Entity
public class Client2 extends Personne {

    private String email;

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Client2(){

    }
    
}
