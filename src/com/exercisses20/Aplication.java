package com.exercisses20;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Aplication {
    public static void main(String[] args) {
//
//        try {
//            new Client("config.properties").start();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

       PropReader reader=  PropReader.getInstance();

        System.out.println(reader.readFrProp("config.properties","server.ip"));





    }
}
