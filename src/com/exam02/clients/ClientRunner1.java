package com.exam02.clients;

import com.exam02.ClientMultiThread;
import com.exam02.auxiliary.LocalhostOrLan;

public class ClientRunner1 {
    public static void main(String[] args) {

        try {
            new ClientMultiThread(LocalhostOrLan.LOCALHOST).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
