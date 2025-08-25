package org.hostpital;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateExecution {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        // Create
//        Student student = new Student(3,"Rqueeb R",876567876567L);
//        session.persist(student);
        // Read All
//        List<Student> studentList = session.createQuery("from Student").list();
//        studentList.forEach(System.out::println);

        // Read Specific column of all
//        List<Object[]> pairList = session.createQuery("select e.firstName,e.contact from Student e", Object[].class).getResultList();
//        for(Object[] pair:pairList){
//            System.out.println(pair[0]+" "+pair[1]);
//        }

        // Read Specific rows
        Query<Student> query = session.createQuery("from Student s where id between :start and :end", Student.class).setParameter("start",1).setParameter("end",3);
        List<Student> studentList = query.getResultList();
        studentList.forEach(System.out::println);

        // Read One
//        Student exist = session.get(Student.class,1);
//        System.out.println(exist);

        // Update
//        exist.setFirstName("Razak Mohamed S, ME");

        // Delete
//        Student exist = session.get(Student.class,3);
//        session.remove(exist);
        tx.commit();
        session.close();
    }
}
