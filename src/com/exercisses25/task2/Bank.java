package com.exercisses25.task2;

public class Bank {
    public void transferMoney(Account src, Account dst, int money) throws InterruptedException {
        Thread transaction = new Thread(new Transaction(src, dst, money));
        transaction.start();
        transaction.join();
    }
}