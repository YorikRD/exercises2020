package com.exercisses20;

import com.exercisses20.auxiliary.LocalhostOrLan;

public class Aplication {
    public static void main(String[] args) {

        try {
            new Client(LocalhostOrLan.LOCALHOST).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
