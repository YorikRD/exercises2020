package com.exercisses23.task2;

import com.Exercises07.pack.schoolTask.VariablesAndRand;
import javafx.css.Match;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Pupil {
    enum Gender {
        MALE, FEMALE
    }
    private int number; // уникальное значение для каждого ученика
    private String name;
    private Gender gender;
    private LocalDate birth;

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public static Pupil getPupil (){
        Pupil pupil = new Pupil();
        pupil.name = VariablesAndRand.randName();
        pupil.gender = Gender.values()[((int)(Math.random()*2))];
        pupil.birth = LocalDate.now().minusYears(com.exam01.VariablesAndRand.rand(8,18)).minusMonths(com.exam01.VariablesAndRand.rand(0,12)).minusDays(com.exam01.VariablesAndRand.rand(0,31));
        pupil.number =pupil.hashCode();
        return pupil;
    }

    @Override
    public String toString() {
        return "Pupil{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", birth=" + birth +
                '}' +'\n';
    }
    public int getAge(){
        return (int)ChronoUnit.YEARS.between(this.getBirth(),LocalDate.now());
    }

    // TODO: добавить все необходимые методы

}
