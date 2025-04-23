package com.jpa.tp06;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Genre {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @ManyToMany(mappedBy = "genres")
    private List<Film> films = new ArrayList<>();

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Genre() {}
    public Genre(String nom) { this.nom = nom; }

   
}
