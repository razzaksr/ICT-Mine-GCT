package org.hostpital.inheritance;

import jakarta.persistence.*;

@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // for single table and joined
//    @GeneratedValue(strategy = GenerationType.AUTO) // for table per class
    private Long id;
    private String brand;
    private String model;

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    public Vehicle(Long id, String brand, String model) {
        this.id = id;
        this.brand = brand;
        this.model = model;
    }

    public Vehicle() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}