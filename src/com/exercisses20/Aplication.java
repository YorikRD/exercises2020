package com.exercisses20;

public class Aplication {
    public static void main(String[] args) {

        try {
            new Client("config.properties").start();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
