package org.hostpital;

import jakarta.persistence.*;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demoPU");
        EntityManager em = emf.createEntityManager();

        // Life cycle
//        em.getTransaction().begin();
//        // Transient
//        Student student = new Student(4,"Rajiya R",876567876567L);
//        em.persist(student);// persist/ save/ Managed by entity manager
//        em.getTransaction().commit();
//        student.setContact(222222222222222L);// detached since not connected with transaction
//        // being managed again
//        em.getTransaction().begin();
////        student.setContact(111111111111111L); // update happens
//        Student existingStudent = em.find(Student.class, 3);
//        // remove
//        em.remove(existingStudent);
//        em.getTransaction().commit();
//        em.close();

        // CRUD Operations
        em.getTransaction().begin();
        Student student = new Student(4,"Rajiya R",876567876567L);
        // Create
        // em.persist(student);

        // Read one via primary key
//        Student stu = em.find(Student.class,1);
//        System.out.println(stu);

//        stu.setFirstName("Razak Mohamed S"); // Update

        // Delete
        // em.remove(stu);

        // Read All we need JPQL since no default one available
//        List<Student> studentList = em.createQuery("from Student", Student.class).getResultList();
//        studentList.forEach(System.out::println);

        // Read specific column of all students
//        List<String> nameList = em.createQuery("select e.firstName from Student e", String.class).getResultList();
//        nameList.forEach(System.out::println);

        // Read two or more specific columns of all students
//        List<Object[]> pairList = em.createQuery("select e.firstName,e.contact from Student e", Object[].class).getResultList();
//        for(Object[] pair:pairList){
//            System.out.println(pair[0]+" "+pair[1]);
//        }

        // Read specific row/ rows
//        TypedQuery<Student> query = em.createQuery("from Student s where id between :start and :end", Student.class);
//        query.setParameter("start", 1);
//        query.setParameter("end", 3);
//        List<Student> studentList = query.getResultList();
//        studentList.forEach(System.out::println);

        em.getTransaction().commit();
        em.close();
    }
}
