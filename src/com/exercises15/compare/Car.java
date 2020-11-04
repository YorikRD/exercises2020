package com.exercises15.compare;

import java.util.Comparator;
import java.util.Objects;

public class Car implements Comparable{
    private String color;
    private String brand;
    private int price;

    public Car(String color, String brand, int price) {
        this.color = color;
        this.brand = brand;
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                '}'+"\n";
    }

    @Override
    public int compareTo(Object o) {
        Objects.requireNonNull(o);
        if (!o.getClass().equals(Car.class)) throw new IllegalArgumentException("Uncomparable!");
        Car other =(Car)o;
        int result = Integer.compare(this.getPrice(),other.getPrice());
        if(result ==0){
            result =this.getColor().compareTo(other.getColor());
        }
        if (result ==0) {
            result = this.getBrand().compareTo(other.getBrand());
        }
        return result;
    }
}
class CarClourComparator implements Comparator<Car> {

    @Override
    public int compare(Car car, Car other) {
        return car.getColor().compareTo(other.getColor());
    }
}