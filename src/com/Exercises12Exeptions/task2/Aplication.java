package com.Exercises12Exeptions.task2;

import com.Exercises12Exeptions.task1.T1ExClass;

import java.util.Arrays;

public class Aplication {

    public static void main(String[] args) {
        T2exContainer container =new T2exContainer(9);
        for (int i = 0; i <container.getExceptionsTrack().length ; i++) {

            try {
                T2exContainer.generatorExRand();
            } catch (RuntimeException r){
                container.putEx(r);
            }
        }
        container.PrintExlist();

    }




}
