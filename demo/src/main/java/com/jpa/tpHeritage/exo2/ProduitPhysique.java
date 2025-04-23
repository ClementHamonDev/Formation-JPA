package com.jpa.tpHeritage.exo2;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PHYSIQUE")
public class ProduitPhysique extends ProduitAVendre {

    private double poids;

    public Object getPoids() {
        return this.poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }
    
    public ProduitPhysique(){

    }
}
