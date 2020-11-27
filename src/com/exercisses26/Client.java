package com.exercisses26;

import com.Exercises07.pack.schoolTask.VariablesAndRand;

import java.util.concurrent.ArrayBlockingQueue;

public class Client extends Thread {
    private ArrayBlockingQueue<Order> pullOfOrdered;
    private ArrayBlockingQueue<Order> pullofPrepared;
    private String nameCl;

    public Client(ArrayBlockingQueue<Order> pullOfOdered, ArrayBlockingQueue<Order> pullofPrepared) {
        this.pullOfOrdered = pullOfOdered;
        this.pullofPrepared = pullofPrepared;
        this.nameCl = VariablesAndRand.randName();
    }

    public String getNameCl() {
        return nameCl;
    }

    @Override
    public void run() {
        while (true) {
            Order madeOrd = Order.getOrder();
            madeOrd.setOrderer(this);
            try {
                pullOfOrdered.put(madeOrd);
                System.out.println(nameCl + " " + Thread.currentThread() + " made an order of: " + madeOrd);
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!pullofPrepared.isEmpty()&&(pullofPrepared.peek()).getOrderer().equals(this)) {
                try {
                    Order received = pullofPrepared.take();
                    System.out.println(nameCl + " " + Thread.currentThread() + " received an order of: " + received);
                } catch (InterruptedException s) {
                    s.printStackTrace();
                }
            }
        }
    }
}

