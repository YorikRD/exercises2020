package com.exercises15.compare;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class ComparingExample {
    public static void main(String[] args) {

        // сортировать по значениям свойств: price, color, brand
        Car blackOpel = new Car("black", "opel", 2000);
        Car redOpel = new Car("red", "opel", 2500);
        Car yellowMazda = new Car("yellow", "mazda", 3000);
        Car greenMazda = new Car("green", "mazda", 3000);
        Car greenReno = new Car("green", "reno", 3000);

        TreeSet<Car> cars = new TreeSet<>();
        cars.add(blackOpel);
        cars.add(redOpel);
        cars.add(yellowMazda);
        cars.add(greenMazda);
        cars.add(greenReno);
        System.out.println(cars);

    }
}