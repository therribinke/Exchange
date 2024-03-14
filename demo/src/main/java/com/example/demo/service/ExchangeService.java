package com.example.demo.service;

import com.example.demo.HibernateSession;
import com.example.demo.dao.model.Exchange;
import com.example.demo.dao.model.ExchangesValues;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ExchangeService {
    SessionFactory sessionFactory = HibernateSession.buildSessionFactory();

    public  List<ExchangesValues> getCourse(String valuename1, String valuename2) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query<ExchangesValues> query = session.createQuery("FROM exchangesvalues " +
                                                    "WHERE (valuename1 = :valuename1) AND " +
                                                    "(valuename2 = :valuename2)",ExchangesValues.class);

        query.setParameter("valuename1",valuename1);
        query.setParameter("valuename2",valuename2);
        List<ExchangesValues> list = query.getResultList();
        session.getTransaction().commit();
        return list;
    }
    public  List<ExchangesValues> getAllCourses() {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query<ExchangesValues> query = session.createQuery("FROM exchangesvalues",ExchangesValues.class);
        List<ExchangesValues> list = query.getResultList();
        session.getTransaction().commit();
        return list;
    }

    public void saveExchangeCourse(ExchangesValues exchangesValues){
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(exchangesValues);
        session.getTransaction().commit();
    }

}
