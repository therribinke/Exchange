
package com.example.demo.service;

import com.example.demo.HibernateSession;
import com.example.demo.dao.model.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


import java.lang.String;
import com.example.demo.dao.model.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.Null;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;


import java.util.List;
@Transactional
@Service
public class UserService {

    SessionFactory sessionFactory =  HibernateSession.buildSessionFactory();

    User user = new User();
    /*Configuration configuration = new Configuration();*/



    public void saveUser(User user){
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(user);
        session.getTransaction().commit();
    }
    public void deleteUser(Long id){
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        user = session.get(User.class,id);
        session.delete(user);
        session.getTransaction().commit();
    }
    public User getUserByID(Long id){
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        user = session.get(User.class,id);
        session.getTransaction().commit();
        return user;
    }
    public User getUserByLogin(String login){
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query<User> query = session.createQuery("FROM users WHERE login = :login",User.class);
        query.setParameter("login",login);
        if (query.getSingleResultOrNull()==null){
            System.out.println("query.getSingleResultOrNull()");
        }
        System.out.println(query.getSingleResultOrNull());

        session.getTransaction().commit();
        return query.getSingleResultOrNull();
    }
    public boolean checkSameLogin(String login){
        return  getUserByLogin(login) == null;
    }

    public String getPasswordByLogin(String login){
        return getUserByLogin(login).getPassword();
    }
    public Long getIDByLogin(String login){
        return getUserByLogin(login).getId();
    }
}

