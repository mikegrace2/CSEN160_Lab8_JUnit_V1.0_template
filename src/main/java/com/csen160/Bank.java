package com.csen160;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, BankAccount> accounts = new HashMap<>();

    public void createAccount(String accountId, String accountHolderName, double initialDeposit) {
        if (this.accounts.containsKey(accountId)) {
            throw new IllegalArgumentException("Account ID already exists.");
        }
        
        BankAccount tempAccount1=new BankAccount(accountId, accountHolderName, initialDeposit);
        this.accounts.put(accountId, tempAccount1);
        System.out.println("createAccount("+accountId+", "+
        									accountHolderName+", "+
        									initialDeposit+")");
    }

    public BankAccount getAccount(String accountId) {
        if (!this.accounts.containsKey(accountId)) {
            throw new IllegalArgumentException("Account not found.");
        }
        
        BankAccount tempAccount=this.accounts.get(accountId);
        System.out.println("getAccount("+accountId+")="+tempAccount);
        return tempAccount;
    }

    public void deleteAccount(String accountId) {
        if (!this.accounts.containsKey(accountId)) {
            throw new IllegalArgumentException("Account not found.");
        }
        BankAccount tempAccount=this.accounts.remove(accountId);
        System.out.println("removeAccount("+accountId+")="+tempAccount);
    }

    public double getTotalFunds() {
        return this.accounts.values().stream().mapToDouble(BankAccount::getBalance).sum();
    }
    
    // Simple account creation
    public static void main(String[] args) {
        Bank myBank = new Bank();
        // Create accounts
        myBank.createAccount("12345", "Mike", 10000);
        myBank.createAccount("46463", "Paul", 500);
        myBank.createAccount("23123", "John", 100);
        
        System.out.println();
        
        // get accounts
        myBank.getAccount("12345");
        try {
        	myBank.getAccount("00711");
        }catch (IllegalArgumentException ex) {
        	System.out.println("Expected Exception, account 00711 does not exists!");
        }
        myBank.getAccount("23123");
        
        System.out.println();
        
        // delete accounts
        myBank.deleteAccount("23123");
        try {
        	myBank.deleteAccount("00711");
        }catch (IllegalArgumentException ex) {
        	System.out.println("Expected Exception, account 00711 does not exists!");
        }
        
        System.out.println();
        
        // Sum of accounts
        System.out.println("Sum of all accounts = "+myBank.getTotalFunds()); 
    }    
}