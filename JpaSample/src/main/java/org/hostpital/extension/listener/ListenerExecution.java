package org.hostpital.extension.listener;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.query.Query;
import org.hostpital.Student;
import org.hostpital.inheritance.Car;
import org.hostpital.inheritance.Motorcycle;

import java.util.List;

public class ListenerExecution {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        SessionFactoryImpl sessionFactoryImpl = (SessionFactoryImpl) factory;
        EventListenerRegistry registry = sessionFactoryImpl.getServiceRegistry()
                .getService(EventListenerRegistry.class);
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        VehicleExtensionListener listener = new VehicleExtensionListener();

        registry.appendListeners(EventType.POST_INSERT, listener);
        registry.appendListeners(EventType.POST_UPDATE, listener);
        registry.appendListeners(EventType.POST_DELETE, listener);

        System.out.println("Listeners are registered");

        Car car = new Car();
        car.setBrand("Mahindra");
        car.setModel("3XO");
        car.setFuelType("Petrol");
        car.setNumberOfDoors(5);
        session.persist(car);

        Motorcycle motorcycle = new Motorcycle();
        motorcycle.setBrand("TVS");
        motorcycle.setModel("Apache200");
        motorcycle.setHasSidecar(false);
        motorcycle.setEngineCapacity(200);
        session.persist(motorcycle);

        tx.commit();
        session.close();
    }

}
