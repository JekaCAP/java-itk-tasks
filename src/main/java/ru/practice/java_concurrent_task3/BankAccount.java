package ru.practice.java_concurrent_task3;

/**
 * @author agent
 * @since 05.12.2025
 */
class BankAccount {
    private final int accountNumber;
    private int balance;

    public BankAccount(int accountNumber, int initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public synchronized void deposit(int amount) {
        balance += amount;
    }

    public synchronized void withdraw(int amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Недостаточно средств на счёте " + accountNumber);
        }
        balance -= amount;
    }

    public synchronized int getBalance() {
        return balance;
    }
}