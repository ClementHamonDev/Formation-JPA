package com.jpa.dao;

import java.util.List;

import com.jpa.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class UserDAO {

    private EntityManagerFactory emf;

    public UserDAO(){
        this.emf = Persistence.createEntityManagerFactory("demoPU");
    }

    public void createUser(String name){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        User user = new User(name);
        em.persist(user);

        transaction.commit();
        em.close();
    }

    public User readUser(int id){   
        EntityManager em = emf.createEntityManager();
        User user = em.find(User.class, id);
        em.close();
        return user;
    }

    public List<User> getAllUsers(){
        EntityManager em = emf.createEntityManager();

        List<User> users = em.createQuery("SELECT u FROM User u", User.class).getResultList();
        em.close();
        return users;
    }

    public void updateUser(int id, String newName){
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        User user = em.find(User.class, id);

        if(user != null){
            user.setName(newName);
        }

        em.getTransaction().commit();
        em.close();
    }

    public void deleteUser(int id){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        User user = em.find(User.class, id);

        if(user != null){
            em.remove(user);
        }

        em.getTransaction().commit();
        em.close();
    }

    
}
