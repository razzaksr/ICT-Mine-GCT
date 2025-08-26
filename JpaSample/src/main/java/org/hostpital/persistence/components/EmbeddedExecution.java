package org.hostpital.persistence.components;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbeddedExecution {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Address address1 = new Address("Salem",636001);
        Address address2 = new Address("Manglore",521098);
        Customer customer = new Customer("Razak Mohamed S",address1,address2);

        session.persist(customer);

        tx.commit();
        session.close();
    }
}
