package org.hostpital.persistence.components;

import jakarta.persistence.*;

@Entity
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;

    public Customer(String fullName, Address communication, Address permanent) {
        this.fullName = fullName;
        this.communication = communication;
        this.permanent = permanent;
    }

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="city",column=@Column(name="temp_city")),
            @AttributeOverride(name="zipCode",column=@Column(name="temp_pin"))
    })
    private Address communication;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="city",column=@Column(name="perm_city")),
            @AttributeOverride(name="zipCode",column=@Column(name="perm_pin"))
    })
    private Address permanent;

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", communication=" + communication +
                ", permanent=" + permanent +
                '}';
    }

    public Customer(Long id, String fullName, Address communication, Address permanent) {
        this.id = id;
        this.fullName = fullName;
        this.communication = communication;
        this.permanent = permanent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Address getCommunication() {
        return communication;
    }

    public void setCommunication(Address communication) {
        this.communication = communication;
    }

    public Address getPermanent() {
        return permanent;
    }

    public void setPermanent(Address permanent) {
        this.permanent = permanent;
    }
}
