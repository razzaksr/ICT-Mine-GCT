package org.hostpital;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    private int id;
    private String firstName;
    private long contact;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", contact=" + contact +
                '}';
    }

    public Student() {
    }

    public Student(int id, String firstName, long contact) {
        this.id = id;
        this.firstName = firstName;
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }
}