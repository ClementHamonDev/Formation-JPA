package com.jpa.entity.Heritage.Subclass;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Produit extends Audit{

    @Id
    @GeneratedValue
    private Long id;

    private String client;
    
    
}
