package com.jpa.tp06;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Role {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @ManyToOne
    private Acteur acteur;

    @ManyToOne
    private Film film;

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Acteur getActeur() {
        return this.acteur;
    }

    public void setActeur(Acteur acteur) {
        this.acteur = acteur;
    }

    public Film getFilm() {
        return this.film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Role() {}

    public Role(String nom, Acteur acteur, Film film) {
        this.nom = nom;
        this.acteur = acteur;
        this.film = film;
    }
}
