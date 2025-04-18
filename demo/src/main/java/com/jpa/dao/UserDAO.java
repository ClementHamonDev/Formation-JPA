package com.jpa.dao;

import java.util.List;

import com.jpa.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class UserDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    public UserDAO(){
        this.emf = Persistence.createEntityManagerFactory("demoPU");
        this.em = emf.createEntityManager();
    }

    public void createUser(String name){
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        User user = new User(name);
        em.persist(user);

        transaction.commit();
    }

    public User readUser(int id){   
        User user = em.find(User.class, id);
        return user;
    }

    public List<User> getAllUsers(){
        List<User> users = em.createQuery("SELECT u FROM User u", User.class).getResultList();
        return users;
    }

    public void updateUser(int id, String newName){
        em.getTransaction().begin();

        User user = em.find(User.class, id);

        if(user != null){
            user.setName(newName);
        }

        em.getTransaction().commit();
    }

    public void deleteUser(int id){
        em.getTransaction().begin();

        User user = em.find(User.class, id);

        if(user != null){
            em.remove(user);
        }

        em.getTransaction().commit();
    }

    
}
