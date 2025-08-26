package org.hostpital.tcl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hostpital.locks.BankAccount;

public class TCLExecution {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.getTransaction();

        try{
            tx.begin();
            // insert
            BankAccount bankAccount = new BankAccount(71L,"Sabari",89000.4);
            session.persist(bankAccount);

            // update
//            BankAccount exists = session.find(BankAccount.class,3L);// will fail since no account with id 3
            BankAccount exists = session.find(BankAccount.class,71L);

            exists.setBalance(exists.getBalance()+2500);
            tx.commit();
            System.out.println("Transaction successful");
        }
        catch(Exception e){
            e.printStackTrace();
            tx.rollback();
            System.out.println("Transaction failed"); // both insertion and update failed since no account to be updated with id 3L
        }

        session.close();
    }
}
