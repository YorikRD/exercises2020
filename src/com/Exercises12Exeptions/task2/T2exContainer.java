package com.Exercises12Exeptions.task2;

import com.Exercises12Exeptions.task1.T1ExClass;

public class T2exContainer {
    private Exception[] exceptionsTrack;
    private int fp;

    public T2exContainer(int length) {
        this.exceptionsTrack = new Exception[length];
    }

    public void putEx(RuntimeException rs) {
        this.exceptionsTrack[fp] = rs;
        fp++;
        if (fp == exceptionsTrack.length) System.out.println("Th track is full");
    }

    public Exception[] getExceptionsTrack() {
        return exceptionsTrack;
    }

    public void PrintExlist(){
        for (int i = 0; i < exceptionsTrack.length; i++) {
            System.out.println("Position of "+i+" on th track is " +exceptionsTrack[i]);
        }
    }

    static void generatorExRand() throws RuntimeException {
        int rnd = (int) (Math.random() * 6);
        switch (rnd) {
            case 0:
                int[] a = new int[2];
                a[3] = 4;
                break;
            case 1:
                int f = 12 / 0;
                break;
            case 2:

                Object obj = new java.util.Date();
                Integer int1 = (Integer) obj;
                break;

            case 3:
                int[] ar = new int[3];
                int b = ar[2];
                break;
            case 4:

                Object o = new Object();
                T2exContainer a342 = new T2exContainer(2);
                a342.putEx((RuntimeException) o);
                break;
            default:

                throw new IllegalArgumentException(" Im to lasy to call it in other way");

        }

    }

}
