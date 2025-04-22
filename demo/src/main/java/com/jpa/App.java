package com.jpa;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.jpa.dao.UserDAO;
import com.jpa.entity.User;
import com.jpa.entity.TP02.Client;
import com.jpa.entity.TP02.Emprunt;
import com.jpa.entity.TP02.Livre;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // UserDAO dao = new UserDAO();
        // dao.createUser("Clément");

        // System.out.println("User bien ajouté");

        // User user = dao.readUser(1);

        // System.out.println("User 1 : " + user);

        // List<User> users = dao.getAllUsers();

        // for (User userInList : users){
        //     System.out.println(userInList);
        // }

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demoPU");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Client client1 = new Client();
            client1.setNom("Hamon");
            client1.setPrenom("Clément");
            em.persist(client1);

            Livre livre1 = new Livre();
            livre1.setAuteur("Orwell");
            livre1.setTitre("1984");

            Livre livre2 = new Livre();
            livre2.setAuteur("Saint-Exupery");
            livre2.setTitre("Le petit Prince");

            em.persist(livre1);
            em.persist(livre2);
            
            Emprunt emprunt = new Emprunt();
            emprunt.setClient(client1);
            emprunt.setDateDebut(LocalDate.now());
            client1.getEmprunts().add(emprunt);

            Set<Livre> livres = new HashSet<>();
            livres.add(livre1);
            livres.add(livre2);
            emprunt.setLivres(livres);

            System.out.println("Emprunt : " + emprunt.getLivres());

            em.persist(emprunt);

            tx.commit();

            System.out.println("Afficher tous les livres empruntés par un client donné");
            Client clientAvecID = em.find(Client.class, client1.getId());

            System.out.println(clientAvecID.getEmprunts());

            for(Emprunt empruntDuClient : clientAvecID.getEmprunts()){
                for(Livre livre: empruntDuClient.getLivres()){
                    System.out.println("Livre: "+ livre.getTitre());
                }
            }

            System.out.println("Ajouter un nouveau livre à un emprunt existant");
            Emprunt empruntAvecID = em.find(Emprunt.class, emprunt.getId());

            em.getTransaction().begin();

            Livre nouveauLivre = new Livre();
            nouveauLivre.setTitre("Moby Dick");
            nouveauLivre.setAuteur("Herman Melville");

            em.persist(nouveauLivre);

            empruntAvecID.getLivres().add(nouveauLivre);

            em.getTransaction().commit();

            System.out.println("Supprimer un emprunt");
            em.getTransaction().begin();

            emprunt.getLivres().clear();

            em.remove(empruntAvecID);

            em.getTransaction().commit();

        } catch (Exception e) {
            if (tx.isActive())
                tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }

    }
}
