package org.hostpital.inheritance;

import jakarta.persistence.Entity;

@Entity
public class Car extends Vehicle {
    private Integer numberOfDoors;
    private String fuelType;

    public Car() {

    }

    // getters and setters

    @Override
    public String toString() {
        return "Car{" +
                "numberOfDoors=" + numberOfDoors +
                ", fuelType='" + fuelType + '\'' +
                '}';
    }

    public Car(Integer numberOfDoors, String fuelType) {
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Integer getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(Integer numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }
}