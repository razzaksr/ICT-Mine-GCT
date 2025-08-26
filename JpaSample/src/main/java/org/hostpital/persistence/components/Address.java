package org.hostpital.persistence.components;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String city;
    private int zipCode;

    public Address() {
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }

    public Address(String city, int zipCode) {
        this.city = city;
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
}
