package com.jpa.entity.TP02;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Compo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "compo")
    private Set<Livre> livres = new HashSet<>();

    @OneToMany(mappedBy = "compo")
    private Set<Emprunt> emprunts = new HashSet<>();
    
}
