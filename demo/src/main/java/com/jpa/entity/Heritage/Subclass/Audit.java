package com.jpa.entity.Heritage.Subclass;

import java.time.LocalDate;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Audit {

    private LocalDate dateAudit;
    
}
