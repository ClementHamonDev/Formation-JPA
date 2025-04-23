package com.jpa.tpHeritage.exo2;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("NUMERIQUE")
public class ProduitNumerique extends ProduitAVendre{

    private double tailleFichier;

    public double getTailleFichier() {
        return this.tailleFichier;
    }

    public void setTailleFichier(double tailleFichier) {
        this.tailleFichier = tailleFichier;
    }

    public ProduitNumerique(){

    }
    
}
