package com.Exercises06.pack.task2;

import java.util.Arrays;

public class Task2Main {
    public static void main(String[] args) {
        Food cheese = new Food("Rocfor",22,31,2,375); // Standart constructor
        Food bread = new Food("Black",7,2,10); // Constructor which calcualates calories
//        Food potatoes = new Food("Potatoues",77);// Constructor which generates a food without full info, emboded via cycle and command String. Just for fun

        Food[] pileOfFood = new Food[12];
        for (int i = 0; i < pileOfFood.length ; i++) {
            pileOfFood[i]=  new Food(); // Method generates random food
        }
        for (int i = 0; i < pileOfFood.length ; i++) {
            System.out.println(pileOfFood[i]);
        }

        MyFoofDiet diet1 = new MyFoofDiet(70,20,30,580,25);
        diet1.addFood(pileOfFood);
        diet1.showList();






    }
}
