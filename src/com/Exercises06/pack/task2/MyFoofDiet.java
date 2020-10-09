package com.Exercises06.pack.task2;

import java.util.IllformedLocaleException;

public class MyFoofDiet {
    private int protAllowed;
    private int fatAllowed;
    private int carbAllowed;
    private int callorAllowed;
    private Food[] myfood;
    private int storied = 0; // it seems to me that it is better to store it in class then to calculate it in any addFood

    public MyFoofDiet(int protAllowed, int fatAllowed, int carbAllowed, int callorAllowed, int nombOfPr) {
        setProtAllowed(protAllowed);
        setFatAllowed(fatAllowed);
        setCarbAllowed(carbAllowed);
        setCallorAllowed(callorAllowed);
        myfood = new Food[nombOfPr];
    }

    public MyFoofDiet(int protAllowed, int fatAllowed, int carbAllowed, int nombOfPr) {
        setProtAllowed(protAllowed);
        setFatAllowed(fatAllowed);
        setCarbAllowed(carbAllowed);
        setCallorAllowed(calorieCalc());
        myfood = new Food[nombOfPr];
    }

    private boolean checkProtein(Food food) {
        return food.getProtein() <= protAllowed;
    }

    private boolean checkFat(Food food) {
        return food.getFat() <= fatAllowed;
    }

    private boolean checkCarb(Food food) {
        return food.getCarbohydrates() <= carbAllowed;
    }

    private boolean checkCall(Food food) {
        return food.getCalories() <= callorAllowed;
    }

    private void setProtAllowed(int protAllowed) {
        if (protAllowed < 0) throw new IllegalArgumentException("Allowed protein must be not negative");
        this.protAllowed = protAllowed;
    }

    private void setFatAllowed(int fatAllowed) {
        if (fatAllowed < 0) throw new IllegalArgumentException("Allowed Fat must be not negative");
        this.fatAllowed = fatAllowed;
    }

    private void setCarbAllowed(int carbAllowed) {
        if (carbAllowed < 0) throw new IllegalArgumentException("Allowed Carbohydrates must be not negative");
        this.carbAllowed = carbAllowed;
    }

    public void setCallorAllowed(int callorAllowed) {
        if (callorAllowed < calorieCalc())
            throw new IllformedLocaleException("The calories should be recalculated properly the minimum for this product is =" + calorieCalc());
        this.callorAllowed = callorAllowed;
    }

    protected int calorieCalc() {
        int min = this.protAllowed * 4 + this.fatAllowed * 9 + this.carbAllowed * 4;
        return min;
    }

    public void addFood(Food... foods) {
        int ch2 = 0;
        while (storied < myfood.length && ch2 < foods.length) {
            if (checkFood(foods[ch2])) {
                this.myfood[storied] = foods[ch2];
                storied++;
                ch2++;
            } else {
                if (!checkProtein(foods[ch2]))
                    System.out.println(foods[ch2].getName() + " Con not be added to myFood it contains " + foods[ch2].getProtein() + " protein allowed  value is " + this.protAllowed);
                if (!checkFat(foods[ch2]))
                    System.out.println(foods[ch2].getName() + " Con not be added to myFood it contains " + foods[ch2].getFat() + " fat allowed  value is " + this.fatAllowed);
                if (!checkCarb(foods[ch2]))
                    System.out.println(foods[ch2].getName() + " Con not be added to myFood it contains " + foods[ch2].getCarbohydrates() + " Carbohydrates allowed  value is " + this.protAllowed);
                if (!checkCall(foods[ch2]))
                    System.out.println(foods[ch2].getName() + " Con not be added to myFood it contains " + foods[ch2].getCalories() + " Callories allowed  value is " + this.callorAllowed);
                ch2++;
            }
        }


    }

    private boolean checkFood(Food food) {
        return (checkProtein(food) && checkFat(food) && checkCarb(food) && checkCall(food));
    }

    public void showList(){
        System.out.println("The list of allowed products for this Food diet is:");
        for (int i = 0; i < storied; i++) {
            System.out.println(myfood[i]);
        }

    }

}
