package paf.lecture.paf_24l.model;

import paf.lecture.paf_24l.exception.AccountInactiveException;
import paf.lecture.paf_24l.exception.InsufficientBalanceException;

public class BankAccount {
    private int id;

    private String name;

    private boolean isActive;
    
    private float balance;

    public boolean isAccountActive() {
        if (this.isActive) {
            return true;
        }
        throw new AccountInactiveException("Account with account ID %d is inactive.".formatted(id));
    }

    public boolean hasSufficientBalance(float amt) {
        if (balance >= amt) {
            return true;
        }
        throw new InsufficientBalanceException("Account %d does not have sufficient funds to make the transfer.".formatted(id));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    
    
}
