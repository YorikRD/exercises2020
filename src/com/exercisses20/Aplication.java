package com.exercisses20;

public class Aplication {
    public static void main(String[] args) {

        System.out.println( PropReader.readFrProp("config.properties","server.ip"));
        System.out.println( PropReader.readFrProp("config.properties","server.port"));
        int check = Integer.parseInt(PropReader.readFrProp("config.properties","server.port"));



    }
}
