package com.jpa;

import java.util.Arrays;
import java.util.List;

import com.jpa.entity.Region;

import jakarta.persistence.*;

public class ConnectionJpa {

    public static void main(String[] args ){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demoPU");
        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();

            //insert a region
            Region r = new Region("Vendée");
            em.persist(r);
            em.getTransaction().commit();
            System.out.println("Nouvelle région ajoutée");

            //find a region
            Region region = em.find(Region.class, 1);
            if(region != null){
                System.out.println(region);
            }

            //update a region
            em.getTransaction().begin();
            Region ancienneRegion = em.find(Region.class, 1);
            ancienneRegion.setNom("Bretagne");
            em.getTransaction().commit();

            //remove a region
            em.getTransaction().begin();
            em.remove(ancienneRegion);
            em.getTransaction().commit();

            List<Region> regions = Arrays.asList(
                    new Region("Île-de-France"),
                    new Region("Nouvelle-Aquitaine"),
                    new Region("Occitanie"),
                    new Region("Auvergne-Rhône-Alpes"),
                    new Region("Hauts-de-France"),
                    new Region("Grand Est"),
                    new Region("Normandie"),
                    new Region("Bourgogne-Franche-Comté"),
                    new Region("Pays de la Loire"),
                    new Region("Bretagne"),
                    new Region("Centre-Val de Loire"),
                    new Region("Provence-Alpes-Côte d'Azur"),
                    new Region("Corse")
            );

            //insert all regions
            em.getTransaction().begin();
            for(Region reg : regions){
                em.persist(reg);
            }
            em.getTransaction().commit();

            //find all regions
            List<Region> toutes = em.createQuery("SELECT r FROM Region r", Region.class).getResultList();
            for(Region toute : toutes){
                System.out.println(toute.getNom());
            }

        } finally {
            em.close();
            emf.close();
        }

    }
    
}
