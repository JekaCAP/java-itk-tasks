package ru.practice.java_concurrent_task3;

/**
 * @author agent
 * @since 05.12.2025
 */
public class ConcurrentBankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        BankAccount alice = bank.openAccount(1000);
        BankAccount bob = bank.openAccount(500);

        Thread t1 = new Thread(() -> bank.transfer(alice, bob, 200), "Transfer-Alice-to-Bob");
        Thread t2 = new Thread(() -> bank.transfer(bob, alice, 100), "Transfer-Bob-to-Alice");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Общий баланс всех счетов: " + bank.getTotalBalance());
        System.out.println("Баланс Alice: " + alice.getBalance());
        System.out.println("Баланс Bob: " + bob.getBalance());
    }
}