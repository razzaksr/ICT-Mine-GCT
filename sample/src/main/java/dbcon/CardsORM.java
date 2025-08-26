package dbcon;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CardsORM {
    private SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public void addCard(Cards card) throws Exception {
        Session session = factory.openSession();
        Transaction tx = session.getTransaction();
        tx.begin();
        session.persist(card);
        tx.commit();
        session.close();
    }
    public List<Cards> getAllCards() throws Exception {
        Session session = factory.openSession();
        Transaction tx = session.getTransaction();
        tx.begin();
        List<Cards> list = session.createQuery("from Cards").list();
        tx.commit();
        session.close();
        return list;
    }
}
