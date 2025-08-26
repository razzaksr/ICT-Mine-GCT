package org.hostpital.criteria;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hostpital.locks.BankAccount;

import java.util.ArrayList;
import java.util.List;

public class CriteriaExecution {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        // criteria
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<BankAccount> query = criteriaBuilder.createQuery(BankAccount.class);
        Root<BankAccount> account = query.from(BankAccount.class);
        // conditions/ constraints
        List<Predicate> predicates = new ArrayList<Predicate>();

        // balance filter
        predicates.add(criteriaBuilder.between(account.get("balance"),1000,50000));
        query.where(predicates.toArray(new Predicate[predicates.size()]));

        Transaction tx = session.beginTransaction();

        session.createQuery(query).getResultList().forEach(System.out::println);

        session.createQuery(query.where(criteriaBuilder.like(criteriaBuilder.lower(account.get("accountHolder")),"%"+"R"))).getResultList().forEach(System.out::println);

        tx.commit();
        session.close();
    }
}
