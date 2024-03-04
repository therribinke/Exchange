
package com.example.demo.service;

import com.example.demo.dao.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;



import com.example.demo.dao.model.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.Null;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserService {



    User user = new User();
    Configuration configuration = new Configuration();

    private long ID=0;


    public void saveUser(User user){
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(user);
        session.getTransaction().commit();

    }
    public void deleteUser(Long id){

    }
    public User getUserByID(Long id){
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        user = session.get(User.class,id);
        session.getTransaction().commit();
        return user;

    }
    public boolean checkSameLogin(String login){
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query<User> query = session.createQuery("FROM users WHERE login = :login",User.class);
        query.setParameter("login",login);
        session.getTransaction().commit();
        return query.getSingleResultOrNull() == null;

    }

   /* public String getPasswordByLogin(String Login){
    configuration.configure();
    SessionFactory sessionFactory = configuration.buildSessionFactory();
    Session session = sessionFactory.openSession();
    session.getTransaction().begin();


    session.getTransaction().commit();

    }
    public Long getIDByLogin(String Login){

    }*/
}

