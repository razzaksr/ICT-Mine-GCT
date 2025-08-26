package org.hostpital.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hostpital.locks.BankAccount;

public class secondLevelCacheExecution {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        // Read multiple times
        Session session1 = factory.openSession();
        session1.beginTransaction();
        BankAccount fetched = session1.find(BankAccount.class,1L);
        System.out.println(fetched);
        session1.getTransaction().commit();
        session1.close();

        Session session2 = factory.openSession();
        session2.beginTransaction();
        fetched = session2.find(BankAccount.class,1L);
        System.out.println(fetched);
        session2.getTransaction().commit();
        session2.close();
    }
}
