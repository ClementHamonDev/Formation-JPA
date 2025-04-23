package com.jpa.cleComposite;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class CommandeProduit {

    @EmbeddedId
    private CommandeProduitID cpid;
    
}
