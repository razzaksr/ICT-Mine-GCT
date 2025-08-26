package org.hostpital.locks;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BankAccount {
    @Id
    private Long id;

    private String accountHolder;

    private double balance;

    public BankAccount() {
    }

    @Override
    public String toString() {
        return "\nBankAccount{" +
                "id=" + id +
                ", accountHolder='" + accountHolder + '\'' +
                ", balance=" + balance +
                '}'+"\n";
    }

    public BankAccount(Long id, String accountHolder, double balance) {
        this.id = id;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}