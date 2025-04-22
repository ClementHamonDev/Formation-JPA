package com.jpa.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Adresse {
    
    private int num;
    private String rue;
    private String ville;
}
