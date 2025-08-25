package org.hostpital;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public final class JPAUtil {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("jpademoPU");


    private JPAUtil() {}


    public static EntityManager em() {
        return emf.createEntityManager();
    }


    public static void shutdown() {
        emf.close();
    }
}