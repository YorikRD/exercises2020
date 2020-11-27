package com.exercisses26;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Application {
    public static void main(String[] args) {
        restrant(12,6,2);
    }

    private static void restrant(int clintN, int waitN, int cookN) {
        ArrayBlockingQueue<Order> pullOfOrdered = new ArrayBlockingQueue<>(waitN * 3, true);
        LinkedBlockingQueue<Order> kitchen = new LinkedBlockingQueue<>(cookN * 3 / 2);
        ArrayBlockingQueue<Order> pullofPrepared = new ArrayBlockingQueue<>(clintN * 3 / 2, true);
        List<Client> clientList= new ArrayList<>();
        for (int c = 0; c < clintN; c++) {
            clientList.add(new Client(pullOfOrdered, pullofPrepared));
        }
        List<Waiter> waiters = new ArrayList<>();
        for (int i = 0; i < waitN; i++) {
            waiters.add(new Waiter(pullOfOrdered, kitchen));
        }
        List<Cook> cooks =new ArrayList<>();
        for (int i = 0; i < cookN ; i++) {
            cooks.add(new Cook(kitchen,pullofPrepared));
        }
        List<Thread> all = new ArrayList<>();
        all.addAll(clientList);
        all.addAll(waiters);
        all.addAll(cooks);
        for (Thread thread : all) {
            thread.start();
        }



    }


}
