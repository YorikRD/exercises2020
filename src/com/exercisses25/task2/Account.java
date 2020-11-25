package com.exercisses25.task2;

import java.util.HashSet;

public class Account {
    private int id; // unique
    private int balance; // доступные средства на аккаунте
    private static HashSet<Integer> useIds= new HashSet<>();

    public Account(int id, int balance) {
        this.id = id;
       setId(id);
       setBalance(balance);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (!useIds.contains(id)) this.id = id;
        else {
            setId((id+332)/27);
            System.out.println("this Id is used it will be changed");
        }
    }

    public int getBalance() {
        return balance;
    }

        public void setBalance(int balance) {
        this.balance = balance;
    }
}
