package com.jpa.cleComposite;

import jakarta.persistence.Embeddable;

@Embeddable
public class CommandeProduitID {

    private String nom_client;
    private String produit_plus_cher;
    private Long UUID;
    
}
