package com.example.demo.database;

public class CurrentAccount {

    String name;
    //Primary key
    int accountNumber;
    double balance;
    SavingsAccount savingsAccount;

    public CurrentAccount(String name, int accountNumber, double balance, SavingsAccount savingsAccount) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.savingsAccount = savingsAccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public SavingsAccount getSavingsAccount() {
        return savingsAccount;
    }

    public void setSavingsAccount(SavingsAccount savingsAccount) {
        this.savingsAccount = savingsAccount;
    }

    public String printSavingsAccount(SavingsAccount savingsAccount){
        return "SavingsAccount{" +
                "accountNumber=" + savingsAccount.accountNumber +
                ", balance=" + savingsAccount.balance +
                '}';

    }

    @Override
    public String toString() {
        return "CurrentAccount{" +
                "name='" + name + '\'' +
                ", accountNumber=" + accountNumber +
                ", balance=" + balance +
                ", savingsAccount=" + printSavingsAccount(savingsAccount) +
                '}';
    }
}
