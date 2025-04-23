package com.jpa;

import java.util.List;

import com.jpa.dao.UserDAO;
import com.jpa.tp06.Acteur;
import com.jpa.tp06.Film;
import com.jpa.tp06.Genre;
import com.jpa.tp06.Pays;
import com.jpa.tp06.Realisateur;
import com.jpa.tp06.Role;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
        // dao.createUser("Clément");

        // System.out.println("User bien ajouté");

        // User user = dao.readUser(1);

        // System.out.println("User 1 : " + user);

        // List<User> users = dao.getAllUsers();

        // for (User userInList : users){
        // System.out.println(userInList);
        // }

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demoPU");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // Acteur a1 = new Acteur("Jean Dujardin"); em.persist(a1);
            // Acteur a2 = new Acteur("Marion Cotillard"); em.persist(a2);
            // Acteur a3 = new Acteur("Vincent Cassel"); em.persist(a3);
            // Acteur a4 = new Acteur("Léa Seydoux"); em.persist(a4);
            // Acteur a5 = new Acteur("Omar Sy"); em.persist(a5);

            // // Création de pays
            // Pays p1 = new Pays("France"); em.persist(p1);
            // Pays p2 = new Pays("États-Unis"); em.persist(p2);
            // Pays p3 = new Pays("Royaume-Uni"); em.persist(p3);

            // // Création de genres
            // Genre g1 = new Genre("Comédie"); em.persist(g1);
            // Genre g2 = new Genre("Drame"); em.persist(g2);
            // Genre g3 = new Genre("Action"); em.persist(g3);
            // Genre g4 = new Genre("Science-fiction"); em.persist(g4);

            // // Création de réalisateurs
            // Realisateur r1 = new Realisateur("Luc Besson"); em.persist(r1);
            // Realisateur r2 = new Realisateur("Christopher Nolan"); em.persist(r2);
            // Realisateur r3 = new Realisateur("Jean-Pierre Jeunet"); em.persist(r3);

            // // Création de films
            // Film f1 = new Film("OSS 117", 100, 2006);
            // f1.getGenres().add(g1); f1.getRealisateurs().add(r1); f1.getPays().add(p1);
            // em.persist(f1);

            // Film f2 = new Film("Inception", 148, 2010);
            // f2.getGenres().add(g2); f2.getGenres().add(g4);
            // f2.getRealisateurs().add(r2); f2.getPays().add(p2);
            // em.persist(f2);

            // Film f3 = new Film("La Haine", 95, 1995);
            // f3.getGenres().add(g2); f3.getRealisateurs().add(r3); f3.getPays().add(p1);
            // em.persist(f3);

            // Film f4 = new Film("Intouchables", 112, 2011);
            // f4.getGenres().add(g1); f4.getGenres().add(g2);
            // f4.getRealisateurs().add(r1); f4.getPays().add(p1);
            // em.persist(f4);

            // Film f5 = new Film("Skyfall", 143, 2012);
            // f5.getGenres().add(g3); f5.getRealisateurs().add(r2); f5.getPays().add(p3);
            // em.persist(f5);

            // // Création de rôles
            // em.persist(new Role("Hubert Bonisseur", a1, f1));
            // em.persist(new Role("Mal", a2, f2));
            // em.persist(new Role("Vinz", a3, f3));
            // em.persist(new Role("Driss", a5, f4));
            // em.persist(new Role("Lucia", a4, f4));
            // em.persist(new Role("Agent M", a1, f5));
            // em.persist(new Role("Infiltrée", a4, f5));
            // em.persist(new Role("Rêveuse", a2, f2));
            // em.persist(new Role("Observateur", a3, f1));
            // em.persist(new Role("Inconnu", a5, f3));

            // Tous les films dans lesquels un acteur donné a joué
            List<Film> filmsActeur = em.createQuery(
                    "SELECT DISTINCT r.film FROM Role r WHERE r.acteur.nom = :nom", Film.class)
                    .setParameter("nom", "Jean Dujardin")
                    .getResultList();

            // Tous les acteurs ayant joué dans un film d’un genre donné
            List<Acteur> acteursGenre = em.createQuery(
                    "SELECT DISTINCT r.acteur FROM Role r JOIN r.film f JOIN f.genres g WHERE g.nom = :genre",
                    Acteur.class)
                    .setParameter("genre", "Drame")
                    .getResultList();

            // Tous les genres associés à des films où un acteur donné a joué
            List<Genre> genresActeur = em.createQuery(
                    "SELECT DISTINCT g FROM Role r JOIN r.film f JOIN f.genres g WHERE r.acteur.nom = :nom",
                    Genre.class)
                    .setParameter("nom", "Omar Sy")
                    .getResultList();

            // Tous les pays dans lesquels ont été diffusés les films d’un genre donné
            List<Pays> paysGenre = em.createQuery(
                    "SELECT DISTINCT p FROM Film f JOIN f.genres g JOIN f.pays p WHERE g.nom = :genre", Pays.class)
                    .setParameter("genre", "Action")
                    .getResultList();

            // Nombre de films par genre
            List<Long[]> nbFilmsGenre = em.createQuery(
                    "SELECT g.nom, COUNT(f) FROM Film f JOIN f.genres g GROUP BY g.nom", Long[].class)
                    .getResultList();

            // Tous les réalisateurs ayant travaillé avec un acteur donné
            List<Realisateur> realisateursActeur = em.createQuery(
                    "SELECT DISTINCT real FROM Role ro JOIN ro.film f JOIN f.realisateurs real WHERE ro.acteur.nom = :nom",
                    Realisateur.class)
                    .setParameter("nom", "Léa Seydoux")
                    .getResultList();


            tx.commit();

        } catch (Exception e) {
            if (tx.isActive())
                tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }

        // Employe emp = new Employe();
        // emp.setNom("Hamon");
        // emp.setPrenom("Clément");
        // emp.setSalaire(10000);
        // emp.setPoste("Formateur");

        // Client2 c = new Client2();
        // c.setNom("Jean");
        // c.setPrenom("Paul");
        // c.setEmail("jean.paul@email.fr");

        // em.persist(c);
        // em.persist(emp);

        // ProduitPhysique pp = new ProduitPhysique();
        // pp.setNom("Ballon");
        // pp.setPoids(1);
        // pp.setPrix(20);

        // ProduitNumerique pn = new ProduitNumerique();
        // pn.setNom("Dark Souls");
        // pn.setPrix(10);
        // pn.setTailleFichier(10);

        // em.persist(pn);
        // em.persist(pp);

        // Article a = new Article();
        // a.setTitre("Mon article");

        // Commentaire com = new Commentaire();
        // com.setContenu("contenuuuuuuuuuuuuuuuuu");

        // em.persist(com);
        // em.persist(a);

        // Bus b = new Bus();
        // b.setCapacite(300);
        // b.setImmatriculation("11 AAA 11");
        // em.persist(b);

        // Trajet trajet = new Trajet();
        // trajet.setDepart("Republique");
        // trajet.setArrivee("Clemenceau");
        // trajet.setVehicule(b);
        // em.persist(trajet);

        // try {
        // Client client1 = new Client();
        // client1.setNom("Hamon");
        // client1.setPrenom("Clément");
        // em.persist(client1);

        // Livre livre1 = new Livre();
        // livre1.setAuteur("Orwell");
        // livre1.setTitre("1984");

        // Livre livre2 = new Livre();
        // livre2.setAuteur("Saint-Exupery");
        // livre2.setTitre("Le petit Prince");

        // em.persist(livre1);
        // em.persist(livre2);

        // Emprunt emprunt = new Emprunt();
        // emprunt.setClient(client1);
        // emprunt.setDateDebut(LocalDate.now());
        // client1.getEmprunts().add(emprunt);

        // Set<Livre> livres = new HashSet<>();
        // livres.add(livre1);
        // livres.add(livre2);
        // emprunt.setLivres(livres);

        // System.out.println("Emprunt : " + emprunt.getLivres());

        // em.persist(emprunt);

        // tx.commit();

        // System.out.println("Afficher tous les livres empruntés par un client donné");
        // Client clientAvecID = em.find(Client.class, client1.getId());

        // System.out.println(clientAvecID.getEmprunts());

        // for(Emprunt empruntDuClient : clientAvecID.getEmprunts()){
        // for(Livre livre: empruntDuClient.getLivres()){
        // System.out.println("Livre: "+ livre.getTitre());
        // }
        // }

        // System.out.println("Ajouter un nouveau livre à un emprunt existant");
        // Emprunt empruntAvecID = em.find(Emprunt.class, emprunt.getId());

        // em.getTransaction().begin();

        // Livre nouveauLivre = new Livre();
        // nouveauLivre.setTitre("Moby Dick");
        // nouveauLivre.setAuteur("Herman Melville");

        // em.persist(nouveauLivre);

        // empruntAvecID.getLivres().add(nouveauLivre);

        // em.getTransaction().commit();

        // System.out.println("Supprimer un emprunt");
        // em.getTransaction().begin();

        // emprunt.getLivres().clear();

        // em.remove(empruntAvecID);

        // em.getTransaction().commit();
        // } catch (Exception e) {
        // if (tx.isActive())
        // tx.rollback();
        // e.printStackTrace();
        // } finally {
        // em.close();
        // emf.close();
        // }

    }
}
