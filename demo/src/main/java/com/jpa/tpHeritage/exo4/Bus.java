package com.jpa.tpHeritage.exo4;

import jakarta.persistence.Entity;

@Entity
public class Bus extends Vehicule{
    private int capacite;

    public int getCapacite() {
        return this.capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }


    public Bus(){
        
    }
}