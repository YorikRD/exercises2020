package com.Exercises06.pack.task2;

import java.util.Arrays;
import java.util.Scanner;

public class Food {
    private String name;
    private int protein;
    private int fat;
    private int carbohydrates;
    private int calories;
    static int exoticIncriment;

    public Food(String name, int protein, int fat, int carbohydrates, int calories) {
        setName(name);
        setProtein(protein);
        setFat(fat);
        setCarbohydrates(carbohydrates);
        setCalories(calories);
    }

    public Food(String name, int protein, int fat, int carbohydrates) {
        setName(name);
        setProtein(protein);
        setFat(fat);
        setCarbohydrates(carbohydrates);
        checkCalorie();
    }

    public Food(){
        exoticIncriment++;
        setName("Exothic food #"+ exoticIncriment);
        setProtein((int)(Math.random()*100));
        setFat((int)(Math.random()*(100-this.protein)));
        setCarbohydrates((int)(Math.random()*(100-this.protein-this.fat)));
        checkCalorie();
    }



    public Food(String name, int calories) {
        setName(name);
        Scanner scanner = new Scanner(System.in);
        while (this.protein == 0 || this.fat == 0 || this.carbohydrates == 0) {
            System.out.println("Two calculate supposed composition please Follow instruction bellow, you must enter at least two non zero value");
            System.out.println("Please enter value for Proteins, if it is known otherwise enter 0 ");
            int prt = scanner.nextInt() * 4;
            System.out.println("Please enter value for Fat, if it is known otherwise enter 0 ");
            int fatGen = scanner.nextInt() * 9;
            System.out.println("Please enter value for Carbohydrates, if it is known otherwise enter 0 ");
            int cB = scanner.nextInt() * 4;
            System.out.println("test Pr =" + prt);
            System.out.println("test fatGen =" + fatGen);
            System.out.println("test cB =" + cB);
            if (oneOfthreeIsZero(prt, fatGen, cB)) {
                int[] arr = new int[]{prt, fatGen, cB};
                Arrays.sort(arr);
                arr[0] = calories - arr[1] - arr[2];
                setProtein(prt / 4);
                setFat(fatGen / 9);
                setCarbohydrates(cB / 4);
                break;
            }
        }
        setCalories(calories);
        System.out.println(this);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Food name must be Filled");
        this.name = name;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        if (protein < 0) throw new IllegalArgumentException("FProtein must be positive or zero");
        this.protein = protein;
        checkCalorie();

    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        if (fat < 0) throw new IllegalArgumentException("Fat must be positive or zero");
        this.fat = fat;
        checkCalorie();
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(int carbohydrates) {
        if (carbohydrates < 0) throw new IllegalArgumentException("Carbohydrates must be positive or zero");
        this.carbohydrates = carbohydrates;
        checkCalorie();
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {

        if (calories < calorieCalc())
            throw new IllegalArgumentException("The calories should be recalculated properly the minimum for this product is =" + calorieCalc());
        if (calories == 0) System.out.println(" Warning this product was created empty");
        this.calories = calories;
    }

    protected int calorieCalc() {
        int min = this.fat * 9 + this.carbohydrates * 4 + this.protein * 4;
        return min;
    }

    protected void checkCalorie() {
        if (this.calories < calorieCalc()) this.calories = calorieCalc();
    }

    private boolean oneOfthreeIsZero(int... ints) {
        int a = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] != 0) a++;
        }
        return (a == ints.length - 1);

    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", protein=" + protein +
                ", fat=" + fat +
                ", carbohydrates=" + carbohydrates +
                ", calories=" + calories +
                '}';
    }
}
