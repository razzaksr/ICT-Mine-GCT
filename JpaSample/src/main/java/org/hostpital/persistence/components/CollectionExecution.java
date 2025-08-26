package org.hostpital.persistence.components;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.stream.Stream;

public class CollectionExecution {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Problem problem = new Problem("Find Two Sum","Kadens algorithm", Stream.of("java","dart","node").toList());
        session.persist(problem);

        tx.commit();
        session.close();
    }
}
