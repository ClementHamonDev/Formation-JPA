package com.jpa.tpHeritage.exo3;

import java.time.LocalDateTime;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@MappedSuperclass
public abstract class AuditTP {

    private LocalDateTime dateCreation;
    private LocalDateTime dateModif;

    @PrePersist
    public void prePersist() {
        this.dateCreation = LocalDateTime.now();
        this.dateModif = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.dateModif = LocalDateTime.now();
    }
    
}
