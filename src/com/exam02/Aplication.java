package com.exam02;

import com.exam02.auxiliary.LocalhostOrLan;

public class Aplication {
    public static void main(String[] args) {

        try {
            new ClientMultiThread(LocalhostOrLan.LOCALHOST).start();
//            new ClientMultiThread("127.0.0.1",8090).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
