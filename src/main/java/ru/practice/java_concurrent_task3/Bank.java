package ru.practice.java_concurrent_task3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author agent
 * @since 05.12.2025
 */
class Bank {
    private final List<BankAccount> accounts = new ArrayList<>();
    private int nextAccountNumber = 1;

    public synchronized BankAccount openAccount(int initialBalance) {
        BankAccount account = new BankAccount(nextAccountNumber++, initialBalance);
        accounts.add(account);
        return account;
    }

    public void transfer(BankAccount from, BankAccount to, int amount) {
        BankAccount firstLock = from.getAccountNumber() < to.getAccountNumber() ? from : to;
        BankAccount secondLock = from.getAccountNumber() < to.getAccountNumber() ? to : from;

        synchronized (firstLock) {
            synchronized (secondLock) {
                from.withdraw(amount);
                to.deposit(amount);
            }
        }
    }

    public int getTotalBalance() {
        int total = 0;
        for (BankAccount account : accounts) {
            synchronized (account) {
                total += account.getBalance();
            }
        }
        return total;
    }
}