package org.hostpital.inheritance;

import jakarta.persistence.Entity;

@Entity
public class Motorcycle extends Vehicle {
    private Integer engineCapacity;
    private Boolean hasSidecar;

    // getters and setters

    public Motorcycle(Long id, String brand, String model) {
        super(id, brand, model);
    }

    public Motorcycle() {
    }

    public Integer getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(Integer engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public Boolean getHasSidecar() {
        return hasSidecar;
    }

    public void setHasSidecar(Boolean hasSidecar) {
        this.hasSidecar = hasSidecar;
    }
}