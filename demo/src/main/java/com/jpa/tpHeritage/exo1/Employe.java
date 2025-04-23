package com.jpa.tpHeritage.exo1;

import jakarta.persistence.Entity;

@Entity
public class Employe extends Personne{
    
    private double salaire;
    private String poste;

    public double getSalaire() {
        return this.salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public String getPoste() {
        return this.poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public Employe(){
        
    }


}
