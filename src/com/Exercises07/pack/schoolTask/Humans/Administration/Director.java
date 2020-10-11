package com.Exercises07.pack.schoolTask.Humans.Administration;

import com.Exercises07.pack.schoolTask.Humans.Human;

public class Director extends Human implements Administrative {

    protected Director(String name, int age) {
        super(name, age);
        setAge(age);
    }

    @Override
    public void setAge(int age) {
        if(age<=25) throw new IllegalArgumentException("Director must have an age of 26 or greater");
        super.setAge(age);
    }

    @Override
    public void startSchoolDay() {
        System.out.println("The Principal "+this.getName()+" declares the begining of a school day!");
    }

    @Override
    public void finishSchoolday() {
        System.out.println("The Principal "+this.getName()+" declares the ending of a school day!");
    }


}
