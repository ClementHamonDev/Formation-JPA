package com.jpa;

import java.util.List;

import com.jpa.dao.UserDAO;
import com.jpa.entity.User;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        UserDAO dao = new UserDAO();
        dao.createUser("Clément");

        System.out.println("User bien ajouté");

        User user = dao.readUser(1);

        System.out.println("User 1 : " + user);

        List<User> users = dao.getAllUsers();

        for (User userInList : users){
            System.out.println(userInList);
        }


    }
}
