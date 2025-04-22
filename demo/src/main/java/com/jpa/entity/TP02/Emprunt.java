package com.jpa.entity.TP02;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Emprunt {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private LocalDate dateDebut;
    private LocalDate dateFin;
    private int delai;

    @ManyToMany
    @JoinTable(name = "emprunt_livre",
    joinColumns = @JoinColumn(name="id_emprunt"),
    inverseJoinColumns = @JoinColumn(name="id_livre") 
    )
    private Set<Livre> livres;

    public Set<Livre> getLivres() {
        return this.livres;
    }

    public void setLivres(Set<Livre> livres) {
        this.livres = livres;
    }

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "compo_id")
    private Compo compo;

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDate getDateDebut() {
        return this.dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return this.dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public int getDelai() {
        return this.delai;
    }

    public void setDelai(int delai) {
        this.delai = delai;
    }


    public Emprunt(){

    }
}
