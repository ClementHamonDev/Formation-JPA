package com.jpa.tpCleComposite;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class HeuresTravaillees {
    
    @EmbeddedId
    private EmployeProjetId id;

    private int nbHeures;
}
