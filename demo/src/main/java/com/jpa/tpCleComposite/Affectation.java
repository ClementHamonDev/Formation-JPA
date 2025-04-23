package com.jpa.tpCleComposite;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Affectation {

    @EmbeddedId 
    private EmployeProjetId id;

    
    
}
