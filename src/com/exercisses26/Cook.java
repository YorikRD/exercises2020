package com.exercisses26;

import com.exam01.VariablesAndRand;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Cook extends Thread {
    private LinkedBlockingQueue<Order> kitchen;
    private ArrayBlockingQueue<Order> pullofPrepared;
    private String nameC;

    public Cook(LinkedBlockingQueue<Order> kitchen, ArrayBlockingQueue<Order> pullofPrepared) {
        this.kitchen = kitchen;
        this.pullofPrepared = pullofPrepared;
        nameC = VariablesAndRand.randName()+" "+VariablesAndRand.randSurname();
    }

    @Override
    public void run() {
        while (true) {
            Order inproc = null;
            try {
                 inproc=kitchen.take();
                System.out.println("Cook "+ nameC+" "+Thread.currentThread()+" has begun preparing the order of: "+inproc);
                Thread.sleep((long) (Math.random() * 796));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (inproc != null) {
                try {
                    pullofPrepared.put(inproc);
                    System.out.println("Cook "+ nameC+" "+Thread.currentThread()+" finished preparing the order of: "+inproc);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
