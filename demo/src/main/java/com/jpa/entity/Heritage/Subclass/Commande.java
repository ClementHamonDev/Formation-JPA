package com.jpa.entity.Heritage.Subclass;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Commande extends Audit {
    
    @Id
    @GeneratedValue
    private Long id;

    private String nom;
    private int prix;
}
