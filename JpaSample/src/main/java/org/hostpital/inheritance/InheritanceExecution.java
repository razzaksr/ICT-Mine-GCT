package org.hostpital.inheritance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class InheritanceExecution {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Car car = new Car();
        car.setBrand("Suzuki");
        car.setModel("Baleno");
        car.setFuelType("Petrol");
        car.setNumberOfDoors(5);
        session.persist(car);

        Motorcycle  motorcycle = new Motorcycle();
        motorcycle.setBrand("Bajaj");
        motorcycle.setModel("Avenger220");
        motorcycle.setHasSidecar(false);
        motorcycle.setEngineCapacity(220);
        session.persist(motorcycle);

//        // read Car
//        System.out.println("Reading cars");
//        List<Car> cars = session.createQuery("from Car").list();
//        cars.forEach(System.out::println);
//        // read Bikes
//        System.out.println("Reading bikes");
//        List<Motorcycle> bikes = session.createQuery("from Motorcycle").list();
//        bikes.forEach(System.out::println);
//        // read Vehicles
//        System.out.println("Reading vehicles");
//        List<Vehicle> vehicles = session.createQuery("from Vehicle ").list();
//        vehicles.forEach(System.out::println);
        tx.commit();
        session.close();
    }
}
