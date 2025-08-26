package org.hostpital.locks;

import jakarta.persistence.LockModeType;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LockExecution {
    public static void withdraw(int amount, String threadName){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
//        BankAccount account = session.find(BankAccount.class, 1L);
//        account.setBalance(300);
//        tx.commit();
//        session.close();

        try {
            System.out.println(threadName + " attempting to lock account...");
            BankAccount account = session.find(BankAccount.class, 1L, LockModeType.PESSIMISTIC_WRITE);
            System.out.println(threadName + " acquired lock.");

            if (account.getBalance() >= amount) {
                account.setBalance(account.getBalance() - amount);
                System.out.println(threadName + " withdrew " + amount + ", new balance: " + account.getBalance());
            } else {
                System.out.println(threadName + " insufficient funds.");
            }

            Thread.sleep(5000); // Simulate long transaction
            tx.commit();
            System.out.println(threadName + " committed.");
        }  catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public static void main(String[] args) {
        // Thread A
        Thread t1 = new Thread(() -> withdraw(1000, "Thread-A"));

        // Thread B
        Thread t2 = new Thread(() -> withdraw(1000, "Thread-B"));

        t1.start();
//        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
//        t2.start();

    }
}
