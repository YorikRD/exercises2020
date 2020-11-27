package com.exercisses26;

import com.exam01.VariablesAndRand;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Waiter extends Thread {
    private String nameW;
    private ArrayBlockingQueue<Order> pullOfOrdered;
    private LinkedBlockingQueue<Order> kitchen;

    public Waiter(ArrayBlockingQueue<Order> pullOfOrdered, LinkedBlockingQueue<Order> kitchen) {
        this.pullOfOrdered = pullOfOrdered;
        this.kitchen = kitchen;
        nameW = VariablesAndRand.randName() + " " + VariablesAndRand.randSurname();
    }

    @Override
    public void run() {
        while (true) {
            Order getted = null;
            try {
                getted = pullOfOrdered.take();
                System.out.println(" Waiter " + nameW + " " + Thread.currentThread() + " received an order " + getted + " from Client " + getted.getOrderer().getNameCl());
                Thread.sleep((long) (Math.random() * 396));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (getted != null) {
                try {
                    kitchen.put(getted);
                    System.out.println(" Waiter " + nameW + " " + Thread.currentThread() + " delivered an order of " + getted + " to kitchen ");

                } catch (InterruptedException s) {
                    s.printStackTrace();
                }
            }
        }
    }
}



