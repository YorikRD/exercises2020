package com.exercisses26;


import java.util.ArrayList;

public class Order {
    private ArrayList<Dishes> orederComposition;
    private Client orderer = null;
    private enum Dishes {
        TOMATO_SOUP(2),FRENCH_ONION_SOUP(1),TOMATO_SALAD(1),CHICKEN_SALAD(1),GRILLED_FISH(2),VEGETABLE_PASTA(3);


        Dishes(int dishsize) {
            this.dishsize = dishsize;
        }

        private int dishsize;
    }

    private Order(ArrayList<Dishes> orederComposition) {
        this.orederComposition = orederComposition;
    }

    public static Order getOrder(){
        Order order = new Order(new ArrayList<>());
        for (int i = 0; i < ((int)(Math.random()*6+1)) ; i++) {
           order.orederComposition.add(Dishes.values()[((int)(Math.random()*Dishes.values().length))]);
        }
        return order;
    }

    public Client getOrderer() {
        return orderer;
    }

    public void setOrderer(Client orderer) {
        this.orderer = orderer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orederComposition=" + orederComposition +
                '}';
    }
}
