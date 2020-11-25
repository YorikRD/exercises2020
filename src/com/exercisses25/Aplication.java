package com.exercisses25;

import com.exercisses25.task1.TopTenMultyThread;
import com.exercisses25.task2.Account;
import com.exercisses25.task2.Bank;

import java.io.IOException;

public class Aplication {
    public static void main(String[] args) {
//        task1Call();
        try {
            task2Call();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void task1Call() {
        TopTenMultyThread testOne = new TopTenMultyThread("resources/sometxt.txt");
        try {
            System.out.println(testOne.getTopTen());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void task2Call() throws InterruptedException {
        Account account1 = new Account(123, 162);
        Account account2 = new Account(123, 162);
        Account account3 = new Account(123, 162);
        Account account4 = new Account(123, 162);
        Account account5 = new Account(123, 162);

        Bank bank = new Bank();
        System.out.println("Before src: " + account1.getBalance() + " dst: " + account2.getBalance());
        bank.transferMoney(account1, account2, 27);
        System.out.println("After src: " + account1.getBalance() + " dst: " + account2.getBalance());
        System.out.println("Before src: " + account1.getBalance() + " dst: " + account2.getBalance());
        bank.transferMoney(account1, account2, 267);
        System.out.println("After src: " + account1.getBalance() + " dst: " + account2.getBalance());
    }
}
