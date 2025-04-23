package com.jpa.tpHeritage.exo4;

import jakarta.persistence.Entity;

@Entity
public class Tramway extends Vehicule {
    
    private int nbRames;

    public int getNbRames() {
        return this.nbRames;
    }

    public void setNbRames(int nbRames) {
        this.nbRames = nbRames;
    }

    public Tramway(){

    }

    
}
