package com.jpa.tp06;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Realisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @ManyToMany(mappedBy = "realisateurs")
    private List<Film> films = new ArrayList<>();

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Film> getFilms() {
        return this.films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public Realisateur() {
    }
    public Realisateur(String nom) { this.nom = nom; }

}
