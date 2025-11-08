package com.csen160;

public class BankAccount {
    private String accountId;
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountId, String accountHolderName, double initialDeposit) {
        if (initialDeposit < 100) {
            throw new IllegalArgumentException("Initial deposit must be at least $100.");
        }
        
        this.accountId = accountId;
        this.accountHolderName = accountHolderName;
        this.balance = initialDeposit;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds.");
        }
        
        balance -= amount;
    }

    public void transfer(BankAccount targetAccount, double amount) {
        if (targetAccount == null) {
            throw new IllegalArgumentException("Target account cannot be null.");
        }
        
        this.withdraw(amount);
        targetAccount.deposit(amount);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId='" + accountId + '\'' +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", balance=" + balance +
                '}';
    }
}