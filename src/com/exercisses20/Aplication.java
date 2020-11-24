package com.exercisses20;

import com.exercisses20.auxiliary.LocalhostOrLan;

public class Aplication {
    public static void main(String[] args) {

        try {
            new Client(LocalhostOrLan.LOCALHOST).start();
//            new Client("127.0.0.1",8090).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
