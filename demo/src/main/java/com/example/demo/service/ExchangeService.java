package com.example.demo.service;

import com.example.demo.HibernateSession;
import com.example.demo.dao.model.ExchangesValues;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ExchangeService {
    SessionFactory sessionFactory = HibernateSession.buildSessionFactory();

    public  List<ExchangesValues> getCourse(String valuesname1, String valuesname2) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query<ExchangesValues> query = session.createQuery("FROM exchangesvalues " +
                                                    "WHERE (valuesname1 = :valuesname1) AND " +
                                                    "(valuesname2 = :valuesname2)",ExchangesValues.class);

        query.setParameter("valuesname1",valuesname1);
        query.setParameter("valuesname2",valuesname2);
        List<ExchangesValues> list = query.getResultList();
        session.getTransaction().commit();
        return list;
    }
}
