package com.example.demo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSession {
    public static SessionFactory buildSessionFactory(){
        Configuration configuration = new Configuration();
        configuration.configure();
        return configuration.buildSessionFactory();
    }
}
