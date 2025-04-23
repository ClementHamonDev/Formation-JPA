package com.jpa.tp06;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Film {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private int duree;
    private int annee;

    @OneToMany(mappedBy = "film")
    private List<Role> roles = new ArrayList<>();

    @ManyToMany
    private List<Genre> genres = new ArrayList<>();

    @ManyToMany
    private List<Realisateur> realisateurs = new ArrayList<>();

    @ManyToMany
    private List<Pays> pays = new ArrayList<>();

    public String getTitre() {
        return this.titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getDuree() {
        return this.duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public int getAnnee() {
        return this.annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public List<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Genre> getGenres() {
        return this.genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Realisateur> getRealisateurs() {
        return this.realisateurs;
    }

    public void setRealisateurs(List<Realisateur> realisateurs) {
        this.realisateurs = realisateurs;
    }

    public List<Pays> getPays() {
        return this.pays;
    }

    public void setPays(List<Pays> pays) {
        this.pays = pays;
    }

    public Film() {}
    public Film(String titre, int duree, int annee) {
        this.titre = titre;
        this.duree = duree;
        this.annee = annee;
    }

}
